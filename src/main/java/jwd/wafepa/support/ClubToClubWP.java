package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Club;
import jwd.wafepa.web.dto.ClubWP;

@Component
public class ClubToClubWP implements Converter<Club, ClubWP> {

	@Override
	public ClubWP convert(Club club) {
		ClubWP clubWP = new ClubWP();

		clubWP.setClubID(club.getClubID());
		clubWP.setName(club.getName());

		return clubWP;
	}

	public List<ClubWP> convert(List<Club> clubs) {
		List<ClubWP> clubsWP = new ArrayList<>();

		for (Club c : clubs) {
			clubsWP.add(convert(c));
		}

		return clubsWP;
	}

}
