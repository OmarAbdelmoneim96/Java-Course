
package xcharttitanic;


public class Passenger {
    
    private String pclass;
    private String survived;
    private String name;
    private String sex;
    private float age;
    private String sibsp;
    private String parch;
    private String ticket;
    private float fare;
    private String cabin;
    private String embarked;
    private String boat;
    private String body;
    private String home_dest;

  

    public String getPclass() {
        return pclass;
    }

    public String getSurvived() {
        return survived;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public float getAge() {
        return age;
    }

    public String getSibsp() {
        return sibsp;
    }

    public String getParch() {
        return parch;
    }

    public String getTicket() {
        return ticket;
    }

    public float getFare() {
        return fare;
    }

    public String getCabin() {
        return cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public String getBoat() {
        return boat;
    }

    public String getBody() {
        return body;
    }

    public String getHome_dest() {
        return home_dest;
    }

    @Override
    public String toString() {
        return "Passenger{" + "pclass=" + pclass + ", survived=" + survived + ", name=" + name + ", sex=" + sex + ", age=" + age + ", sibsp=" + sibsp + ", parch=" + parch + ", ticket=" + ticket + ", fare=" + fare + ", cabin=" + cabin + ", embarked=" + embarked + ", boat=" + boat + ", body=" + body + ", home_dest=" + home_dest + '}';
    }
    
    
    
}
