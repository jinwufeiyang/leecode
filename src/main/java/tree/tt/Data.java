package tree.tt;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Data<Key extends Comparable<Key>, Value> {
    private Key key;
    private Value value;

    public void displayData() {
        System.out.println("/" + key + "----" + value);
    }
}
