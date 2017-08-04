import javax.swing.JComboBox;
//расширяем класс JComboBox
public class MyJComboBox extends JComboBox{
	//конструктор принимает массив обхектов для отображение в списке
	public MyJComboBox(Object[] objectList) {
		super();
		//устанавливаем модель и передаем ей наш массив объектов(именно модель отвечает за отображение массива в списке!!!)
		//модель сама знает как отобразить элементы массива в списке
		//класс MyComboBoxModel расширяет класс DefaultComboBoxModel - класс модели для JComboBox по умолчанию
		setModel(new MyComboBoxModel(objectList));
	}
}
