package fi.lahtevanoja.springtest.card;

import fi.lahtevanoja.springtest.models.Skill;

public class CardSkill {
    private String name;
    private int rating;

    CardSkill(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    CardSkill(Skill skill) {
        this.name = skill.getName();
        this.rating = skill.getRating();
    }

    CardSkill() {
        this.name = "";
        this.rating = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
