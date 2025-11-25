package io.agrisense.adapters.in.web;

import io.agrisense.ports.in.ProcessMeasurementUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/measurements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MeasurementController {

    @Inject
    ProcessMeasurementUseCase processMeasurementUseCase;

    @POST
    public Response createMeasurement(MeasurementRequest request) {
        try {
            processMeasurementUseCase.processMeasurement(
                request.getApiKey(), 
                request.getValue(), 
                request.getUnit()
            );
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                          .entity(e.getMessage())
                          .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Internal server error")
                          .build();
        }
    }

    public static class MeasurementRequest {
        private String apiKey;  
        private double value;
        private String unit;

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }


        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }
}