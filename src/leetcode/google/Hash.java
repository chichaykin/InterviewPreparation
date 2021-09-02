package leetcode.google;

public class Hash {
    int a;
    int b;
    int c;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hash hash = (Hash) o;

        if (a != hash.a) return false;
        if (b != hash.b) return false;
        return c == hash.c;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }
}
