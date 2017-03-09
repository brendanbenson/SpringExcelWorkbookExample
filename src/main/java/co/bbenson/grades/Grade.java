package co.bbenson.grades;

public class Grade {
    private String name;
    private String grade;

    public Grade(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade1 = (Grade) o;

        if (name != null ? !name.equals(grade1.name) : grade1.name != null) return false;
        return grade != null ? grade.equals(grade1.grade) : grade1.grade == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        return result;
    }
}
