package atd.tenth;

import atd.common.Status;

public class BloomFilter implements IBloomFilter {

    private Status addStatus = Status.NIL;
    private Status containsStatus = Status.NIL;

    private final int len;
    private int bits;

    public BloomFilter(int len) {
        this(len, 0);
    }

    public BloomFilter(int len, int bits) {
        this.len = len;
        this.bits = bits;
    }

    @Override
    public void add(String element) {
        var hash1 = hash1(element);
        var hash2 = hash2(element);

        bits |= hash1;
        bits |= hash2;
        addStatus = Status.OK;
    }

    @Override
    public boolean contains(String element) {
        var hash1 = hash1(element);
        var hash2 = hash2(element);

        return (bits & hash1) >= hash1 &&
               (bits & hash2) >= hash2;
    }

    @Override
    public Status getAddStatus() {
        return addStatus;
    }

    @Override
    public Status getContainsStatus() {
        return containsStatus;
    }

    private int hash1(String str1) {
        int result = 0;

        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            result = result * 17 + code;
            result %= len;
        }

        return result;
    }

    private int hash2(String str1) {
        int result = 0;

        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            result = result * 223 + code;
            result %= len;
        }

        return result;
    }
}
