package victor.clean.lambdas;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

public class OptionalVsNPE {

	public static void main(String[] args) {
		Customer customer = new Customer();
		double discount = customer.getProfileOpt()
				.map(Profile::getGoldCard)
				.map(GoldCard::getDiscount)
				.orElse(0d);
		System.out.println("discount:  "+discount);
	}
}

class Customer {
	@Getter @Setter private Profile profile;
	
	public Optional<Profile> getProfileOpt() {
		return Optional.ofNullable(profile);
	}
}

class Profile {
	@Getter @Setter private GoldCard goldCard;
}

class GoldCard {
	@Getter @Setter private double discount;
}
