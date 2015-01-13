package Main;

import javax.swing.SwingUtilities;

import model.LlistaPersones;
import view.JFramePersona;
import controller.Controller;
//Programa principal
public class TestGui {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//creo els objectes
				LlistaPersones llista = new LlistaPersones();
				JFramePersona frame = new JFramePersona();
				frame.setVisible(true);
				frame.setSize(600, 300);//ajusto el tamany del frame
				//Passo la vista i el model al controlador per fer-ne la gestió
				Controller controller = new Controller(llista,frame);
				controller.control();
			}
		});
	}
}


