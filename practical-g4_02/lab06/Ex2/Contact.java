public class Contact {
    String name;
    String num;

    public Contact(String name, String num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Contact other)) {
            return false;
        }
        return this.name.equals(other.name) && this.num.equals(other.num);
    }

    @Override
    public String toString() {
        return name + "\t" + num;
    }
}