package testrailclient;

import org.json.simple.JSONArray;

public class TestRailProject extends TestRailAPICalls
{
    private int project_id;
    private String project_name;

    // TO DO
    public TestRailProject(String base_url, String user, String password,
                           String project_name)
    {
        super(base_url, user, password);
        this.project_name = project_name;
        //this.project_id = setProjectId(project_name);
    }

    public TestRailProject(String base_url, String user, String password,
                           int project_id)
    {
        super(base_url, user, password);
        this.project_id=project_id;
    }

    /**
     * Get/Set ProjectId
     *
     * Returns/sets the project id used for the API requests.
     */
    public int getProjectId()
    {
        return this.project_id;
    }
    public String getProjectName()
    {
        return this.project_name;
    }

    // TO DO
    private int get_project_id_by_name(String project_name) throws Exception{
        JSONArray projects = (JSONArray) this.get_projects();
        for (Object project : projects){
            if (project==this.project_name){
                System.out.println("POINT");
            }
        }
        return 0;
    }


}
