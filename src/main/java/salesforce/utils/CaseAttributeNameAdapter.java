/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.utils;

import java.util.HashMap;
import java.util.Map;

public final class CaseAttributeNameAdapter {
    private static final Map<String, String> ATTRIBUTES_NAMES = new HashMap<>();
    static {
        ATTRIBUTES_NAMES.put("descripcion", "description");
        ATTRIBUTES_NAMES.put("estado", "status");
        ATTRIBUTES_NAMES.put("tipo", "type");
        ATTRIBUTES_NAMES.put("correoelectronicoWeb", "webEmail");
        ATTRIBUTES_NAMES.put("ultimamodificacionpor", "lastModifiedBy");
        ATTRIBUTES_NAMES.put("nombreWeb", "webName");
        ATTRIBUTES_NAMES.put("prioridad", "priority");
        ATTRIBUTES_NAMES.put("propietariodelcaso", "caseOwner");
        ATTRIBUTES_NAMES.put("motivodelcaso", "caseReason");
        ATTRIBUTES_NAMES.put("fechaHoradecierre", "dateTimeClosed");
        ATTRIBUTES_NAMES.put("asunto", "subject");
        ATTRIBUTES_NAMES.put("telefonodelcontacto", "contactPhone");
        ATTRIBUTES_NAMES.put("comentariosinternos", "internalComments");
        ATTRIBUTES_NAMES.put("correoelectronicodelcontacto", "contactEmail");
        ATTRIBUTES_NAMES.put("nombredelcontacto", "contactName");
        ATTRIBUTES_NAMES.put("fechaHoradeapertura", "dateTimeOpened");
        ATTRIBUTES_NAMES.put("creadopor", "createdBy");
        ATTRIBUTES_NAMES.put("origendelcaso", "caseOrigin");
        ATTRIBUTES_NAMES.put("numerodelcaso", "caseNumber");
        ATTRIBUTES_NAMES.put("companiaWeb", "webCompany");
        ATTRIBUTES_NAMES.put("telefonoWeb", "webPhone");
        ATTRIBUTES_NAMES.put("nombredelacuenta", "accountName");
    }

    private CaseAttributeNameAdapter() {
    }

    /**
     * Gets the attribute name.
     *
     * @param key the value to search for the attribute name
     * @return a String with the name
     */
    public static String getCaseAttributeName(final String key) {
        if (ATTRIBUTES_NAMES.containsKey(key)) {
            return ATTRIBUTES_NAMES.get(key);
        }
        return key;
    }
}
