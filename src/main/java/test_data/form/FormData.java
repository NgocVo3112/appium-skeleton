package test_data.form;

public class FormData {
    private String field;

    public FormData(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "formData{" +
                "field='" + field + '\'' +
                '}';
    }
}
