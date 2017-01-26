package be.cegeka.bibliothouris.domain.members;

public class Member {

    private String INSZ;
    private String lastName;
    private String firstName;
    private String street;
    private String number;
    private String postalCode;
    private String city;

    public Member(String INSZ, String lastName, String firstName, String street, String number, String postalCode, String city) {
        this.INSZ = INSZ;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getINSZ() {
        return INSZ;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }


    public String getShortDetailsMembers (){
        return String.format("%s %s, %s (%s)", lastName, firstName, city, INSZ);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        return INSZ.equals(member.INSZ);
    }

    @Override
    public int hashCode() {
        return INSZ.hashCode();
    }


}