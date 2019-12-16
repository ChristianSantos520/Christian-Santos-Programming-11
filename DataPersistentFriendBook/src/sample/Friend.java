package sample;

public class Friend {
    String name = "";
    int age = 0;
    String favoriteColor = "";

    Friend(String name, int age, String favoriteColor) {
        this.name = name;
        this.age = age;
        this.favoriteColor = favoriteColor;
    }

    public Friend(String line) {
        int indexOfComma = line.indexOf(',');
        name = line.substring(0, indexOfComma);
        line = line.substring(indexOfComma + 1);
        indexOfComma = line.indexOf(',');
        age = Integer.parseInt(line.substring(0, indexOfComma));
        favoriteColor = line.substring(indexOfComma + 1);
    }

    public String toDataLine() {
        return name + "," + age + "," + favoriteColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }
}
