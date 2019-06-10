

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * 
 * @author Edson Moreira Cezar
 **/
public class RecursiveTreeKeyValue extends JFrame {

	ArrayList<String> blocked = new ArrayList<String>();

	public RecursiveTreeKeyValue() {
		super("Simple Tree");

		TreeMap<Object, Object> doors = new TreeMap<Object, Object>();

		TreeMap<Object, Object> room = new TreeMap<Object, Object>();

		blocked.add("block");

		room.put("First", "Entrance");
		room.put("Second", "Entrance");
		room.put("Third", "Entrance");
		room.put("Fourth", "block");

		doors.put("House", "Entrance");
		doors.put("Kitchen", "Entrance");
		doors.put("Bathroom", "Entrance");

		doors.put("son", room);

		doors.put("son2", room);

		DefaultMutableTreeNode root = build(doors, 1);
		JTree tree = new JTree(root);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JScrollPane scrollPane = new JScrollPane(tree);
		c.add(scrollPane);

		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String args[]) {
		RecursiveTreeKeyValue app = new RecursiveTreeKeyValue();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private DefaultMutableTreeNode build(TreeMap<Object, Object> doors, Integer a) {

		DefaultMutableTreeNode node = new DefaultMutableTreeNode(a), son;

		// Print keys and values
		for (Object door : doors.keySet()) {
			Object doorName = doors.get(door);
			String teste = door.toString();
			if (teste.contains("son")) {
				a++;
				son = build((TreeMap<Object, Object>) doorName, a);
				node.add(son);
			} else {
				son = new DefaultMutableTreeNode(door);

				if (!blocked.contains(doorName)) {

					node.add(son);

				}
			}

		}

		return node;
	}

}
