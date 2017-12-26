package testrailclient;

import com.gurock.testrail.APIException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class TestRailProject extends TestRailAPICalls
{
    private int project_id;
    private String project_name;
    private boolean fuse = true;
    private String fuse_message = "DO NOT TRY TO DO IT !!!";

    public TestRailProject(String base_url, String user, String password,
                           String project_name) throws Exception {
        super(base_url, user, password);
        this.project_name = project_name;
        this.project_id = this.get_project_id_by_name();
    }

    public TestRailProject(String base_url, String user, String password,
                           int project_id) throws Exception {
        super(base_url, user, password);
        this.project_id=project_id;
        this.project_name = this.get_project_name_by_id();
    }

    private int get_project_id_by_name() throws Exception {
        JSONArray projects = (JSONArray) this.get_projects();
        for (Object project : projects) {
            JSONObject obj = (JSONObject) project;
            String name = (String) obj.get("name");
            if (name.equals(this.project_name)) {
                return (int) obj.get("id");
            }
        }
        throw new APIException(String.format("Project '%s' not found",
                this.project_name));
    }

    private String get_project_name_by_id() throws Exception {
        JSONObject project = (JSONObject) this.get_project(this.project_id);
        return (String) project.get("name");
    }

    /**
     * Get/Set ProjectId
     *
     * Returns/sets the project id used for the API requests.
     */
    public int getProjectId() {
        return this.project_id;
    }

    public String getProjectName() {
        return this.project_name;
    }

    // API: Project calls

    public Object get_cases_project(int suite_id, int section_id) throws
            Exception {
        return super.get_cases(this.project_id, suite_id, section_id);
    }

    public Object get_configs_project() throws Exception {
        return super.get_configs(this.project_id);
    }
    
    public Object add_config_group_project(Object data) throws Exception {
        return super.add_config_group(this.project_id, data);
    }
    
    public Object get_milestones_project(String filter) throws Exception {
        return super.get_milestones(this.project_id, filter);
    }
    public Object get_plans_project(String filter) throws Exception {
        return super.get_plans(this.project_id, filter);
    }

    public Object add_plan_project(Object data) throws Exception {
        return super.add_plan(this.project_id, data);
    }

    public Object get_current_project() throws Exception {
        return super.get_project(this.project_id);
    }

    public Object update_current_project(Object data) throws Exception {
        return super.update_project(this.project_id, data);
    }

    public Object delete_current_project() throws Exception {
        if (fuse) {
            return super.delete_project(this.project_id);
        } else {
            throw new Exception(this.fuse_message);
        }
    }

    public Object get_runs_project(String filter) throws Exception {
        return super.get_runs(this.project_id, filter);
    }

    public Object add_run_project(Object data) throws Exception {
        return super.add_run(this.project_id, data);
    }

    public Object get_sections_project(int suite_id) throws Exception {
        return super.get_sections(this.project_id, suite_id);
    }

    public Object add_section_project(Object data) throws Exception {
        return super.add_section(this.project_id, data);
    }

    public Object get_suites_project() throws Exception {
        return super.get_suites(this.project_id);
    }

    public Object add_suite_project(Object data) throws Exception {
        return super.add_suite(this.project_id, data);
    }

    public Object get_templates_project() throws Exception {
        return super.get_templates(this.project_id);
    }

    // Auxiliary methods

    public Object get_suite_by_name(String suite_name) throws Exception {
        JSONArray suites = (JSONArray) this.get_suites_project();
        for (Object suite : suites) {
            JSONObject obj = (JSONObject) suite;
            String name = (String) obj.get("name");
            if (name.equals(suite_name)) {
                return obj;
            }
        }
        throw new APIException(String.format("Suite '%s' not found",
                suite_name));
    }

    public Object get_section_by_name(int suite_id, String section_name)
            throws Exception {
        JSONArray sections = (JSONArray) this.get_sections_project(suite_id);
        for (Object section : sections) {
            JSONObject obj = (JSONObject) section;
            String name = (String) obj.get("name");
            if (name.equals(section_name)) {
                return obj;
            }
        }
        throw new APIException(String.format("Section '%s' not found",
                section_name));
    }

    //TO DO: fix default parameters for method
    public Object get_milestone_by_name(String milestone_name) throws
            Exception {
        JSONArray milestones = (JSONArray) this.get_milestones_project("");
        for (Object milestone : milestones) {
            JSONObject obj = (JSONObject) milestone;
            String name = (String) obj.get("name");
            if (name.equals(milestone_name)) {
                return obj;
            }
        }
        throw new APIException(String.format("Milestone '%s' not found",
                milestone_name));
    }

    // TO DO: test this method !
    public Object get_submilestones(String milestone_name) throws Exception {
        JSONArray submilestones = new JSONArray();
        JSONArray milestones = (JSONArray) this.get_milestone_by_name(
                milestone_name);

        for (Object sub : milestones) {
            JSONObject obj = (JSONObject) sub;
            obj.get("milestones");
            submilestones.add(obj);

        }
        return submilestones;
    }
}
