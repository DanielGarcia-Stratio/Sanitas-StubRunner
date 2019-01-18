import groovy.json.JsonSlurper
import org.springframework.cloud.contract.spec.Contract
import wiremock.org.apache.commons.lang3.ObjectUtils

import java.text.SimpleDateFormat

//if date is not especified current date is returned

Date hoy = new Date()
SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-DD");
String strHoy = sm.format(hoy)

Contract.make {
    description "should return the full info of the visit"
    request {
        method "GET"
        url("/visits") {

            // Each parameter is specified in form
            // `'paramName' : paramValue` where parameter value
            // may be a simple literal or one of matcher functions,
            // all of which are used in this example.
            queryParameters {
                parameter 'agenda': value(consumer(regex("[A-Z]+[0-9]+")), producer("XDA123412"))
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
                scheduledTime: $(p(anyDateTime()),c("${strHoy}T00:00:00")),
                arrivalTime: $(p(anyDateTime()),c("${strHoy}T02:00:00")),
                agenda: $(p(anyNonEmptyString()),c("${fromRequest().query("agenda")}")),
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