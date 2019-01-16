import groovy.json.JsonSlurper
import org.springframework.cloud.contract.spec.Contract
def jsonSlurper = new JsonSlurper()
def object = jsonSlurper.parseText'''{
    "patientInfo":{
        "name": "Pepe",
        "firstSurname":"Florez",
        "secondSurname":"Garcia",
        "gender": "Male",
        "medicalHistory":"HXIS1233"
    },
    "visitStatus": "scheduled",
    "scheduledTime": "10:10, 10/10/1010",
    "arrivalTime": "10:10, 10/10/1010",
    "agenda": "XDA123412",
    "center": "Moraleja",
    "resource": "EF Maria Gimenez Navarro",
    "visitType": "Revision",
    "comments": "Vive en una zona con alta contaminación",
    "insurance": "Sanitas SA",
    "observation": "Ha sufrido anteriormente de neumonia",
    "visitChannel": "Videollamada",
    "overload": ""
}'''
Contract.make {
    description "should return the full info of the visit"
    request {
        url "/visits"
        method "GET"

    }
    response {
        status 200
        body(object)
    }
}