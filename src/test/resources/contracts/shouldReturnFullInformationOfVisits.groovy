import groovy.json.JsonSlurper
import org.springframework.cloud.contract.spec.Contract
def jsonSlurper = new JsonSlurper()

Contract.make {
    description "should return the full info of the visit"
    request {
        url "/visits"
        method "GET"

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
                scheduledTime: $(p(anyDateTime()),c("2010-06-15T00:00:00")),
                arrivalTime: $(p(anyDateTime()),c("2010-06-15T02:00:00")),
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