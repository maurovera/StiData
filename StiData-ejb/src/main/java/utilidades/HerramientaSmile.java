package utilidades;

import java.awt.Color;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import smile.Network;
import smile.SMILEException;

@Stateless
@LocalBean
public class HerramientaSmile {

	// crea una red
	public void crearRed() {

		//try {
			Network net = new Network();

			// Se crea el concepto1:
			// un nodo que representa un evento discreto aleatorio.
			net.addNode(Network.NodeType.Cpt, "Concepto1");
			// se le agrega dos estados.
			net.setOutcomeId("Concepto1", 0, "Exito");
			net.setOutcomeId("Concepto1", 1, "Fallo");

			// Se crea el concepto2:
			// un nodo que representa un evento discreto aleatorio.
			net.addNode(Network.NodeType.Cpt, "Concepto2");
			// se le agrega dos estados.
			net.setOutcomeId("Concepto2", 0, "Exito");
			net.setOutcomeId("Concepto2", 1, "Fallo");

			// Se crea el padre. Que es el tema.:
			net.addNode(Network.NodeType.TruthTable, "Tema1");
			net.addOutcome("Tema1", "Aprobado");
			net.addOutcome("Tema1", "NoAprobado");
			net.deleteOutcome("Tema1", 0);
			net.deleteOutcome("Tema1", 0);

			// Adding an arc from "conceptos" to "Tema":
			net.addArc("Concepto1", "Tema1");
			net.addArc("Concepto2", "Tema1");

			// definicion de las probabilidades apriori del nodo concepto1
			double[] concepto1Def = { 0.5, 0.5 };
			net.setNodeDefinition("Concepto1", concepto1Def);

			// definicion de las probabilidades apriori del nodo concepto2
			double[] concepto2Def = { 0.5, 0.5 };
			net.setNodeDefinition("Concepto2", concepto2Def);

			// probabilidades a posteriori de tema1
			// esto se deberia de calcular por debajo.
			double[] tema1Def = { 1.0,1.0, 0.4,0.4, 0.6,0.6,0.0,0.0 };
			net.setNodeDefinition("Tema1", tema1Def);
			
			
			// Changing the nodes' spacial and visual attributes:
			net.setNodeBgColor("Concepto1", Color.red);
			net.setNodeTextColor("Concepto1", Color.white);
			net.setNodeBorderColor("Concepto1", Color.black);
			net.setNodeBorderWidth("Concepto1", 2);

			net.setNodeBgColor("Concepto2", Color.green);
			net.setNodeTextColor("Concepto2", Color.black);
			net.setNodeBorderColor("Concepto2", Color.red);
			net.setNodeBorderWidth("Concepto2", 2);

			net.setNodePosition("Tema1", 30, 100, 60, 30);

			net.writeFile("/home/mauro/Documentos/conceptoTema.xdsl");

		//} catch (SMILEException e) {
			//System.out.println("no funca");
		//	System.out.println(e.getMessage());
		//}

	}
}
