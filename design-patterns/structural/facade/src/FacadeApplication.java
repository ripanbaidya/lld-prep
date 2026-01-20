// Main
public class FacadeApplication {

    public static void main(String[] args) {
        // Creating an object of DeploymentFacade class
        DeploymentFacade deploymentFacade = new DeploymentFacade();

        // Deploy to Production
        deploymentFacade.deployApplication("main", "prod.server");

        // Deploy a feature branch to staging
        System.out.println("\n--- Deploying feature branch to staging ---");
        deploymentFacade.deployApplication("feature/new-ui", "staging.server");
    }

}