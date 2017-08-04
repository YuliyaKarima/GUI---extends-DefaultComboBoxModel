import javax.swing.DefaultComboBoxModel;
 //расширяем класс DefaultComboBoxModel для отображения списка наших объектов - просто передаем ссылку на  массив Object
public class MyComboBoxModel extends DefaultComboBoxModel{
	 public MyComboBoxModel(Object[] objectList ) {
   	 super(objectList);
     }
}
