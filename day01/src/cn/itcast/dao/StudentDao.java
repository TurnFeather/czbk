package cn.itcast.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.itcast.domain.Student;
import cn.itcast.util.DocumentUtil;

//�쳣���׵Ļ����ϲ��ܽ�����У�
//�ϲ�����?�ˣ��Լ����봦�?

public class StudentDao {

	// ���ѧ����Ϣ��XML��
	public boolean createStudent(Student s) {
		// Ŀ�꣺�ڸ�Ԫ��exam�����student��Ԫ��
		boolean result = false;
		try {
			Document document = DocumentUtil.getDocument();

			// ��һ��������name��location��Ԫ�ز�������������
			Element nameE = document.createElement("name");
			nameE.setTextContent(s.getName());
			Element locationE = document.createElement("location");
			locationE.setTextContent(s.getLocation());
			Element gradeE = document.createElement("grade");
			gradeE.setTextContent(s.getGrade() + "");

			// ����studentԪ�ز�����������
			Element studentE = document.createElement("student");
			studentE.setAttribute("idcard", s.getIdcard());
			studentE.setAttribute("examid", s.getExamid());

			// ����student��name�ȵĸ��ӹ�ϵ
			studentE.appendChild(nameE);
			studentE.appendChild(locationE);
			studentE.appendChild(gradeE);
			// �õ�examԪ�أ���student�ҽ���ȥ
			document.getFirstChild().appendChild(studentE);
			//

			DocumentUtil.write2xml(document);
			result = true;
		} catch (Exception e) {
			throw new RuntimeException(e); // ��һ���ܼ���쳣����������쳣�ˣ��쳣ת�壬�������쳣��
		}
		return result;
	}

	// ���׼��֤�Ų�ѯѧ����Ϣ�����ѧ����ڣ�����null
	public Student findStudent(String examid) {
		Student s = null;
		try {
			// �õ�Document����
			Document document = DocumentUtil.getDocument();
			// �õ�����student����
			NodeList list = document.getElementsByTagName("student");
			// ��vstudentԪ�أ��Д����examid���Ե�ȡֵ�Ƿ��c���M��ą���ƥ��
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) node;
					if (e.getAttribute("examid").equals(examid)) {
						// ���ƥ�䣺�f���ҵ��ˌW�����W����
						s = new Student();
						// �O�ô�W����ĸ�������
						s.setExamid(examid);
						s.setIdcard(e.getAttribute("idcard"));
						s.setName(e.getElementsByTagName("name").item(0)
								.getTextContent());
						s.setLocation(e.getElementsByTagName("location")
								.item(0).getTextContent());
						s.setGrade(Float.parseFloat(e
								.getElementsByTagName("grade").item(0)
								.getTextContent()));
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return s;
	}

	// ���ѧ������ɾ��ѧ������˲����ڄt����false
	public boolean deleteStudent(String name) {
		boolean result = false;

		try {
			// �õ�Document����
			Document document = DocumentUtil.getDocument();
			// �õ����е�nameԪ��
			NodeList list = document.getElementsByTagName("name");
			// ��vnameԪ�أ��Д������w�����Ƿ�ͅ���һ��
			for (int i = 0; i < list.getLength(); i++) {
				// ���һ�£��ҵ���İְֵİְ֣�Ȼ��h����İְ֣�Ȼ�጑��XML�ęn
				Node n = list.item(i);
				if (n.getTextContent().equals(name)) {
					n.getParentNode().getParentNode()
							.removeChild(n.getParentNode());
					// ����XML�ęn
					DocumentUtil.write2xml(document);
					result = true;
					break;
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}
}
