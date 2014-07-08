public class Person {

    final private String personName;
    final private String personAddress;
    final private String eMail;
    final private int personAge;

    private Person(Builder builder) {
        this.personName = builder.personName;
        this.personAddress = builder.personAddress;
        this.personAge = builder.personAge;
        this.eMail = builder.eMail;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public int getPersonAge() {
        return personAge;
    }

    public String geteEMail(){
        return eMail;
    }


    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personAddress='" + personAddress + '\'' +
                ", personAge=" + personAge +
                ", e-mail=" + eMail +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj){
            return true;
        }

        if (obj == null){
            return false;
        }

        if (!(obj instanceof Person)){
            return false;
        }

        if (this.getPersonName().equals(((Person) obj).getPersonName())) {
            if (this.getPersonAddress().equals(((Person) obj).getPersonAddress())) {
                if (this.getPersonAge() == ((Person) obj).getPersonAge()) {
                    if (this.eMail == ((Person) obj).geteEMail()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;
        result = prime * result + (int) personAge;
        result = prime * result + (personAddress == null ? 0 : personAddress.hashCode());
        result = prime * result + (personName == null ? 0 : personName.hashCode());
        result = prime * result + (eMail == null ? 0 : eMail.hashCode());
        return result;
    }



    public static class Builder{
        private String personName;
        private String personAddress;
        private int personAge;
        private String eMail;


        public Builder(){

        }

        public Builder(Person original){
            this.personName = original.personName;
            this.personAddress = original.personAddress;
            this.personAge = original.personAge;
            this.eMail = original.eMail;

        }

        public Builder personName(String name){
            this.personName = name;
            return this;
        }

        public Builder personAddress(String address){
            this.personAddress = address;
            return this;
        }

        public Builder personAge(int age){
            this.personAge = age;
            return this;
        }

        public Builder eMail(String eMail){
            this.eMail = eMail;
            return this;
        }


        public Person build(){
            return new Person(this);
        }
    }

}

