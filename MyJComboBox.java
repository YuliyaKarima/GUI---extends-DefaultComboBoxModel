import javax.swing.JComboBox;
//��������� ����� JComboBox
public class MyJComboBox extends JComboBox{
	//����������� ��������� ������ �������� ��� ����������� � ������
	public MyJComboBox(Object[] objectList) {
		super();
		//������������� ������ � �������� �� ��� ������ ��������(������ ������ �������� �� ����������� ������� � ������!!!)
		//������ ���� ����� ��� ���������� �������� ������� � ������
		//����� MyComboBoxModel ��������� ����� DefaultComboBoxModel - ����� ������ ��� JComboBox �� ���������
		setModel(new MyComboBoxModel(objectList));
	}
}
