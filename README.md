# Receipt-Creator
Creates receipts for food you order


#[**REQUIRES THE FAST-CLASSPATH-SCANNER**](https://github.com/lukehutch/fast-classpath-scanner)

#Diagram of how it works
![alt tag](http://i.imgur.com/uyDRGah.png)


#To add new products
####Create a new class like so
```
package menu.items.rj;

import java.math.BigDecimal;

public class ExampleItem extends Item{
 
 public ExampleItem(){
    super(String "NAME", int Calories, BigDecimal Price );
  }
}
```
