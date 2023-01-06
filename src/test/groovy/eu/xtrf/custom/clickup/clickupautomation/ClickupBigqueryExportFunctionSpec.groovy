package eu.xtrf.custom.clickup.clickupautomation;
import io.micronaut.http.*
import io.micronaut.gcp.function.http.*
import spock.lang.*

class ClickupBigqueryExportFunctionSpec extends Specification {

    @Shared @AutoCleanup
    HttpFunction function = new HttpFunction()

    void "test function"() {
        when:"The function is executed"
        GoogleHttpResponse response = function.invoke(HttpMethod.GET, "/clickupBigqueryExport")

        then:"The response is correct"
        response.status == HttpStatus.OK
    }

    void "test post function"() {
        when:"The POST function is executed"
        SampleInputMessage sampleInputMessage = new SampleInputMessage("Test Name")
        HttpRequest request = HttpRequest.POST("/clickupBigqueryExport", sampleInputMessage).contentType(MediaType.APPLICATION_JSON_TYPE)
        GoogleHttpResponse response = function.invoke(request)

        then:"The response is correct"
        response.status == HttpStatus.OK
    }
}
