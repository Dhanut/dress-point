package shopping;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

import java.util.ArrayList;
import java.util.List;

public class QueryCallServlet {


    String nameToString, priceToString, brandToString;
    public static void main(String args[]){
        ArrayList<Cloth> resultList = new ArrayList<Cloth>();

        FileManager.get().addLocatorClassLoader(QueryCallServlet.class.getClassLoader());
        Model model = FileManager.get().loadModel("F:\\L4S1\\Thisaru\\semantic\\setup\\New folder\\dress-point\\src\\dresspointSunday350.owl");
//===============================================================================================================
         //model.write(System.out, "RDF/JSON");

        String queryString = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "PREFIX foaf:<http://xmlns.com/foaf/0.1/>"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                + "PREFIX clothing: <http://www.dresspoint.com/ontologies/clothing#> "
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "SELECT ?clothname ?clothPrice ?clothSize ?clothPicPath "
                + "WHERE {"
                + "?cloth clothing:hasClothName ?clothname;"
                + "       clothing:hasSize ?size;"
                + "       clothing:hasClothPrice ?clothPrice;"
                +"        clothing:picturePath ?clothPicPath."
                + "?size clothing:hasSizeValue ?clothSize.}";
          /*      + "?product footware:hasSize ?size FILTER (?size = " + size + ")."
                + "?product footware:isTypeOf ?sType FILTER (?sType = \"" + type + "\")."
                + "} LIMIT 5";*/

//===================================================================================================================
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);
        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                Cloth cloth = new Cloth();
                QuerySolution solution = results.nextSolution();
                Literal clothname   = solution.getLiteral("clothname");

                Literal clothPrice = solution.getLiteral("clothPrice");
                Literal clothSize  = solution.getLiteral("clothSize");
                Literal clothPicturePath  = solution.getLiteral("clothPicPath");

               cloth.setClothName(String.valueOf(clothname));
               cloth.setClothPrice(clothPrice.getDouble());
               cloth.setClothSize(String.valueOf(clothSize));
               cloth.setClothImagePath(String.valueOf(clothPicturePath));

                resultList.add(cloth);

            }
        } finally {

            qexec.close();
        }

        for(int i=0;i<resultList.size();i++){
            System.out.print(resultList.get(i).getClothName()+"  ");
            System.out.print(resultList.get(i).getClothPrice()+"  ");
            System.out.println(resultList.get(i).getClothSize()+"  ");

//
        }

    }

}
