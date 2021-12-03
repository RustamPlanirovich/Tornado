package fx

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.collections.FXCollections
import javafx.scene.control.TextField
import tornadofx.*
import tornadofx.View
import tornadofx.label

class HelloView : View() {

    private var firstName: TextField by singleAssign()
    private var lastName: TextField by singleAssign()
    private var booleanProperty = SimpleBooleanProperty()
    private var stringProperty = SimpleStringProperty()

    private val cities = FXCollections.observableArrayList(
        "Moscow", "Voronezh", "Kostroma", "Tikhvin"
    )


    override val root = vbox {
        hbox{
            label("Hello first"){
            }
           firstName = textfield { }
        }
        hbox{
            label("Hello last"){}
            lastName = textfield { }
        }
        checkbox ("CheckBox", booleanProperty){
            action {
                println(isSelected)
            }
        }
        combobox(stringProperty,cities) {  }
        button("Load") {
            action {
                println("${firstName.text} ${lastName.text} ${stringProperty.value}")
                booleanProperty.value = true
            }
        }
    }
}