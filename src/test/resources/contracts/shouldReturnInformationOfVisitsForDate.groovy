import groovy.json.JsonSlurper
import org.springframework.cloud.contract.spec.Contract
import wiremock.org.apache.commons.lang3.ObjectUtils

import java.text.SimpleDateFormat
//if date is not especified current date is returned

SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-DD");
String strDate = sm.format(2015-12-06)

String agendaId = ""

Contract.make {
    description "should return the full info of the visit"
    request {
        method "GET"
        urlPath("/visits") {

            // Each parameter is specified in form
            // `'paramName' : paramValue` where parameter value
            // may be a simple literal or one of matcher functions,
            // all of which are used in this example.
            queryParameters {
                parameter 'date': value(consumer(regex(isoDate())), producer("1010-11-15"))
            }
        }
    }
    response {
        status 200
        body([
                patientInfo :[
                        name : $(p(anyNonEmptyString()), c("Pepe")),
                        firstSurname: $(p(anyNonEmptyString()),c("Florez")),
                        secondSurname: $(p(anyNonEmptyString()), c("Garcia")),
                        gender:$(p(regex('(male|female)')),c("male")),
                        medicalHistory: $(p(anyNonEmptyString()),c("XDSSI"))
                ],
                visitStatus : $(p(regex('(scheduled|done|canceled)')), c("scheduled")),
                scheduledTime: "${fromRequest().query("date")}T10:30:00",
                arrivalTime: "${fromRequest().query("date")}T10:30:00",
                agenda: $(p(anyNonEmptyString()),c("XDD")),
                center:$(p(anyNonEmptyString()),c("Moraleja")),
                resource:$(p(anyNonEmptyString()),c("EF")),
                service: "enfermeria",
                visitType: "revision",
                insurance: "Sanitas SA",
                observation: "Ha sufrido anteriormente de neumonia",
                visitChannel: $(p(regex('(videollamada|presencial|domicilio)')),c("videollamada")),
                overload : $(p(aBoolean()),c(false))
        ])
    }
}