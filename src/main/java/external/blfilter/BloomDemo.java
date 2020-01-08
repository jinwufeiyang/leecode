package external.blfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomDemo {

    public static void main(String[] args) {
        BloomFilter filter = BloomFilter.create(Funnels.integerFunnel(), 100000, 0.01);
        for (int i=0; i<1000;i++) {
            filter.put(i);
        }
    }
}
