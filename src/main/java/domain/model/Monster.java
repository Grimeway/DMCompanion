package domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Monster {
    private String name;
    private String size;
    private String type;
    private String subtype;
    private String alignment;
    private int armor_class;
    private int hit_points;
    private String hit_dice;
    private String speed;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int strength_save;
    private int dexterity_save;
    private int constitution_save;
    private int intelligence_save;
    private int wisdom_save;
    private int charisma_save;
    private String damage_vulnerabilities;
    private String damage_resistances;
    private String damage_immunities;
    private String condition_immunities;
    private String senses;
    private String languages;
    private String challenge_rating;

    public int getIntelligence_save() {
        return intelligence_save;
    }

    public void setIntelligence_save(int intelligence_save) {
        this.intelligence_save = intelligence_save;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getArmor_class() {
        return armor_class;
    }

    public void setArmor_class(int armor_class) {
        this.armor_class = armor_class;
    }

    public int getHit_points() {
        return hit_points;
    }

    public void setHit_points(int hit_points) {
        this.hit_points = hit_points;
    }

    public String getHit_dice() {
        return hit_dice;
    }

    public void setHit_dice(String hit_dice) {
        this.hit_dice = hit_dice;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getStrength_save() {
        return strength_save;
    }

    public void setStrength_save(int strength_save) {
        this.strength_save = strength_save;
    }

    public int getDexterity_save() {
        return dexterity_save;
    }

    public void setDexterity_save(int dexterity_save) {
        this.dexterity_save = dexterity_save;
    }

    public int getConstitution_save() {
        return constitution_save;
    }

    public void setConstitution_save(int constitution_save) {
        this.constitution_save = constitution_save;
    }

    public int getWisdom_save() {
        return wisdom_save;
    }

    public void setWisdom_save(int wisdom_save) {
        this.wisdom_save = wisdom_save;
    }

    public int getCharisma_save() {
        return charisma_save;
    }

    public void setCharisma_save(int charisma_save) {
        this.charisma_save = charisma_save;
    }


    public String getDamage_vulnerabilities() {
        return damage_vulnerabilities;
    }

    public void setDamage_vulnerabilities(String damage_vulnerabilities) {
        this.damage_vulnerabilities = damage_vulnerabilities;
    }

    public String getDamage_resistances() {
        return damage_resistances;
    }

    public void setDamage_resistances(String damage_resistances) {
        this.damage_resistances = damage_resistances;
    }

    public String getDamage_immunities() {
        return damage_immunities;
    }

    public void setDamage_immunities(String damage_immunities) {
        this.damage_immunities = damage_immunities;
    }

    public String getCondition_immunities() {
        return condition_immunities;
    }

    public void setCondition_immunities(String condition_immunities) {
        this.condition_immunities = condition_immunities;
    }

    public String getSenses() {
        return senses;
    }

    public void setSenses(String senses) {
        this.senses = senses;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getChallenge_rating() {
        return challenge_rating;
    }

    public void setChallenge_rating(String challenge_rating) {
        this.challenge_rating = challenge_rating;
    }
}
