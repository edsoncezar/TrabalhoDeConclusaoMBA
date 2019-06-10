

/**
 Este exemplo mostra como criar uma JTree bem
 simples. Os itens s�o fornecidos como um array
 de objetos, de forma que cada sub-array
 constitui uma se��o da �rvore. Os elementos s�o
 inseridos em suas devidas posi��es usando uma
 fun��o recursiva.
 
 @author edson
**/


import javax.swing.*;
import java.awt.*;
import javax.swing.tree.*;

public class RecursiveTree extends JFrame{
  
	public RecursiveTree(){
    super("Simple JTree");
	
    Object[] languages = {
      "Languages",
      new Object[]{
        "Compiladas",
        "C++",
        "Delphi"
      }, 
      new Object[]{
        "Interpretadas",
        "JavaScript",
        "Python",
        "Ruby"
      }, 
      new Object[]{
    	"Edson",
    	"JavaScript",
    	"Python",
    	new Object[]{
    	    	"Edson",
    	    	"JavaScript",
    	    	"Python",
    	    	"Ruby"
    	},
       }
    };

    DefaultMutableTreeNode root = build(languages);
    JTree tree = new JTree(root);  

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
			
    JScrollPane scrollPane = new JScrollPane(tree);
    c.add(scrollPane);
    	
    setSize(400, 300);
    setVisible(true);
  }
	
  public static void main(String args[]){
    RecursiveTree app = new RecursiveTree();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private DefaultMutableTreeNode build(Object[] hier){
    
	 DefaultMutableTreeNode node = new DefaultMutableTreeNode(hier[0]), son;
    
    for(int i = 1; i < hier.length; i++){
      Object sub_node = hier[i];
      if(sub_node instanceof Object[])
        son = build((Object[])sub_node);
      else
        son = new DefaultMutableTreeNode(sub_node);
      node.add(son);
    }

    return(node);
  }
}
