import org.testng.annotations.Test;
import salesforce.utils.CaseAttributeNameAdapter;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import static core.utils.StringAdapter.replaceSpecialCharacters;
import static salesforce.utils.AdaptStringToAttribute.changeFieldName;

public class FakeTest {
    @Test
    public void test100() {
        System.out.println(ResourceBundle.getBundle("internationalization/i18NCases",
                new Locale("es")).getString("caseOwner"));
        System.out.println(ResourceBundle.getBundle("internationalization/i18NCases",
                new Locale("en")).getString("caseOwner"));
    }

    @Test
    public void test1023() {
        Map<String, String> myMap = new HashMap<>();
        myMap.put(changeFieldName(replaceSpecialCharacters("Propietario del caso")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Estado")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Número del caso")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Prioridad")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Nombre del contacto")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Teléfono del contacto")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Nombre de la cuenta")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Correo electrónico del contacto")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Tipo")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Origen del caso")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Motivo del caso")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Correo electrónico Web")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Compañía Web")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Nombre Web")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Teléfono Web")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Fecha/Hora de apertura")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Fecha/Hora de cierre")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Product")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Engineering Req Number")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Potential Liability")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("SLA Violation")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Creado por")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Última modificación por")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Asunto")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Descripción")), "");
        myMap.put(changeFieldName(replaceSpecialCharacters("Comentarios internos")), "");
        System.out.println(myMap);
    }

    @Test
    public void test1() {
        String text = "Teléfono del contacto";
//        System.out.println(text.replace("ñ", "n"));
//        String newText = Normalizer.normalize(text, Normalizer.Form.NFD);
//        System.out.println(newText);
//        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//        System.out.println(pattern.matcher(newText).replaceAll(""));
//        System.out.println(text.replaceAll("[^\\p{ASCII}]", ""));
//        System.out.println(text.replaceAll("\\p{M}", ""));
        System.out.println(replaceSpecialCharacters(text));
    }

    @Test
    public void test55() {
//        System.out.println(TestHello.valueOf("propietariodelcaso"));
//        System.out.println(TestHello.valueOf("propietariodelcaso").getEnglishValue());
        System.out.println(CaseAttributeNameAdapter.getCaseAttributeName("numerodelcaso"));
        System.out.println(CaseAttributeNameAdapter.getCaseAttributeName("caseNumber"));
    }
}
