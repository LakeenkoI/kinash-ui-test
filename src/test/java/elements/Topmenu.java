package elements;

import com.codeborne.selenide.ElementsCollection;
import lombok.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topmenu {

    ElementsCollection menuTop = $$("div.maintopmenu div");


    public void clickTopMenu(String displayName) {
        menuTop.findBy(text(displayName)).click();
    }


}
