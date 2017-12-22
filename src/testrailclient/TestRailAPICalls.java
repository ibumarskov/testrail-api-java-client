package testrailclient;

import com.gurock.testrail.APIClient;

//TO DO: set filter as optional parameter
public class TestRailAPICalls extends APIClient {
    public TestRailAPICalls (String base_url, String user, String password){
        super(base_url);
        this.setUser(user);
        this.setPassword(password);
    }

    // API: Cases

    public Object get_case(int case_id) throws Exception {
        String uri = String.format("get_case/%d", case_id);
        return this.sendGet(uri);
    }

    public Object get_cases(int project_id, int suite_id, int section_id) 
            throws Exception {
        String uri = String.format("get_cases/%d&suite_id=%d&section_id=%d",
                project_id, suite_id, section_id);
        return this.sendGet(uri);
    }
    
    public Object add_case(int section_id, Object data) throws Exception {
        String uri = String.format("add_case/%d", section_id);
        return this.sendPost(uri, data);
    }
    
    public Object update_case(int case_id, Object data) throws Exception {
        String uri = String.format("update_case/%d", case_id);
        return this.sendPost(uri, data);
    }
    
    public Object delete_case(int case_id) throws Exception {
        String uri = String.format("delete_case/%d", case_id);
        return this.sendPost(uri, null);
    }
    
    // API: Case Fields

    public Object get_case_fields() throws Exception {
        String uri = "get_case_fields";
        return this.sendGet(uri);
    }
    
    // API: Case Types

    public Object get_case_types() throws Exception {
        String uri = "get_case_types";
        return this.sendGet(uri);
    }
    
    // API: Configurations

    public Object get_configs(int project_id) throws Exception {
        String uri = String.format("get_configs/%d", project_id);
        return this.sendGet(uri);
    }
    
    public Object add_config_group(int project_id, Object data) 
            throws Exception {
        String uri = String.format("add_config_group/%d", project_id);
        return this.sendPost(uri, data);
    }
    
    public Object add_config(int config_group_id, Object data) 
            throws Exception {
        String uri = String.format("add_config/%d", config_group_id);
        return this.sendPost(uri, data);
    }
    
    public Object update_config_group(int config_group_id, Object data) 
            throws Exception {
        String uri = String.format("update_config_group/%d", config_group_id);
        return this.sendPost(uri, data);
    }
    
    public Object update_config(int config_id, Object data) throws Exception {
        String uri = String.format("update_config/%d", config_id);
        return this.sendPost(uri, data);
    }
    
    public Object delete_config_group(int config_group_id) throws Exception {
        String uri = String.format("delete_config_group/%d", config_group_id);
        return this.sendPost(uri, null);
    }
    
    public Object delete_config(int config_id) throws Exception {
        String uri = String.format("delete_config/%d", config_id);
        return this.sendPost(uri, null);
    }
    
    // API: Milestones

    public Object get_milestone(int milestone_id) throws Exception {
        String uri = String.format("get_milestone/%d", milestone_id);
        return this.sendGet(uri);
    }

    public Object get_milestones(int project_id, String filter)
            throws Exception {
        String uri = String.format("get_milestones/%d", project_id);
        if (filter != "") {
            uri += uri + filter;
        }
        return this.sendGet(uri);
    }

    public Object add_milestone(int project_id, Object data) throws Exception {
        String uri = String.format("add_milestone/%d", project_id);
        return this.sendPost(uri, data);
    }
    
    public Object update_milestone(int milestone_id, Object data) 
            throws Exception {
        String uri = String.format("update_milestone/%d", milestone_id);
        return this.sendPost(uri, data);
    }
    
    public Object delete_milestone(int milestone_id) throws Exception {
        String uri = String.format("delete_milestone/%d", milestone_id);
        return this.sendPost(uri, null);
    }
    
    // API: Plans

    public Object get_plan(int plan_id) throws Exception {
        String uri = String.format("get_plan/%d", plan_id);
        return this.sendGet(uri);
    }

    public Object get_plans(int project_id, String filter) throws Exception {
        String uri = String.format("get_plans/%d", project_id);
        if (filter != "") {
            uri += uri + filter;
        }
        return this.sendGet(uri);
    }
    
    public Object add_plan(int project_id, Object data) throws Exception {
        String uri = String.format("add_plan/%d", project_id);
        return this.sendPost(uri, data);
    }
    
    public Object add_plan_entry(int plan_id, Object data) throws Exception {
        String uri = String.format("add_plan_entry/%d", plan_id);
        return this.sendPost(uri, data);
    }
    
    public Object update_plan(int plan_id, Object data) throws Exception {
        String uri = String.format("update_plan/%d", plan_id);
        return this.sendPost(uri, data);
    }
    
    public Object update_plan_entry(int plan_id, int entry_id, Object data)
            throws Exception {
        String uri = String.format("update_plan_entry/%d/%d", plan_id, entry_id);
        return this.sendPost(uri, data);
    }
    
    public Object close_plan(int plan_id) throws Exception {
        String uri = String.format("close_plan/%d", plan_id);
        return this.sendPost(uri, null);
    }
    
    public Object delete_plan(int plan_id) throws Exception {
        String uri = String.format("delete_plan/%d", plan_id);
        return this.sendPost(uri, null);
    }
    
    public Object delete_plan_entry(int plan_id, int entry_id) throws Exception {
        String uri = String.format("delete_plan_entry/%d/%d", plan_id, entry_id);
        return this.sendPost(uri, null);
    }
    
    // API: Priorities

    public Object get_priorities() throws Exception {
        String uri = "get_priorities";
        return this.sendGet(uri);
    }
    
    // API: Projects

    public Object get_project(int project_id) throws Exception {
        String uri = String.format("get_project/%d", project_id);
        return this.sendGet(uri);
    }

    public Object get_projects() throws Exception {
        String uri = "get_projects";
        return this.sendGet(uri);
    }

    public Object add_project(Object data) throws Exception {
        String uri = "add_project";
        return this.sendPost(uri, data);
    }
    
    public Object update_project(int project_id, Object data) throws Exception {
        String uri = String.format("update_project/%d", project_id);
        return this.sendPost(uri, data);
    }
    
    public Object delete_project(int project_id) throws Exception {
        String uri = String.format("delete_project/%d", project_id);
        return this.sendPost(uri, null);
    }

    // API: Results

    public Object get_results(int test_id, String filter) throws Exception {
        String uri = String.format("get_results/%d", test_id);
        if (filter != "") {
            uri += uri + filter;
        }
        return this.sendGet(uri);
    }
    
    public Object get_results_for_case(int run_id, int case_id, String filter)
            throws Exception {
        String uri = String.format("get_results_for_case/%d/%d", run_id,
                case_id);
        if (filter != "") {
            uri += uri + filter;
        }
        return this.sendGet(uri);
    }

    public Object get_results_for_run(int run_id, String filter)
            throws Exception {
        String uri = String.format("get_results_for_run/%d", run_id);
        if (filter != "") {
            uri += uri + filter;
        }
        return this.sendGet(uri);
    }

    public Object add_result(int test_id, Object data) throws Exception {
        String uri = String.format("add_result/%d", test_id);
        return this.sendPost(uri, data);
    }

    public Object add_result_for_case (int run_id, int case_id, Object data)
            throws Exception {
        String uri = String.format("add_result_for_case/%d/%d", run_id,
                case_id);
        return this.sendPost(uri, data);
    }

    public Object add_results(int run_id, Object data) throws Exception {
        String uri = String.format("add_results/%d", run_id);
        return this.sendPost(uri, data);
    }

    public Object add_results_for_cases(int run_id, Object data) throws Exception {
        String uri = String.format("add_results_for_cases/%d", run_id);
        return this.sendPost(uri, data);
    }

    // API: Result Fields

    public Object get_result_fields() throws Exception {
        String uri = "get_result_fields";
        return this.sendGet(uri);
    }

    // API: Runs

    public Object get_run(int run_id) throws Exception {
        String uri = String.format("get_run/%d", run_id);
        return this.sendGet(uri);
    }

    public Object get_runs(int project_id, String filter) throws Exception {
        String uri = String.format("get_runs/%d", project_id);
        if (filter != "") {
            uri += uri + filter;
        }
        return this.sendGet(uri);
    }

    public Object add_run(int project_id, Object data) throws Exception {
        String uri = String.format("add_run/%d", project_id);
        return this.sendPost(uri, data);
    }

    public Object update_run(int run_id, Object data) throws Exception {
        String uri = String.format("update_run/%d", run_id);
        return this.sendPost(uri, data);
    }

    public Object close_run(int run_id) throws Exception {
        String uri = String.format("close_run/%d", run_id);
        return this.sendPost(uri, null);
    }

    public Object delete_run(int run_id) throws Exception {
        String uri = String.format("delete_run/%d", run_id);
        return this.sendPost(uri, null);
    }

    // API: Sections

    public Object get_section(int section_id) throws Exception {
        String uri = String.format("get_section/%d", section_id);
        return this.sendGet(uri);
    }

    public Object get_sections(int project_id, int section_id) throws Exception {
        String uri = String.format("get_sections/%d&suite_id=%d", project_id,
                section_id);
        return this.sendGet(uri);
    }

    public Object add_section(int project_id, Object data) throws Exception {
        String uri = String.format("add_section/%d", project_id);
        return this.sendPost(uri, data);
    }

    public Object update_section(int section_id, Object data) throws Exception {
        String uri = String.format("update_section/%d", section_id);
        return this.sendPost(uri, data);
    }

    public Object delete_section(int section_id) throws Exception {
        String uri = String.format("delete_section/%d", section_id);
        return this.sendPost(uri, null);
    }

    // API: Statuses

    public Object get_statuses() throws Exception {
        String uri = "get_statuses";
        return this.sendGet(uri);
    }

    // API: Suites

    public Object get_suite(int suite_id) throws Exception {
        String uri = String.format("get_suite/%d", suite_id);
        return this.sendGet(uri);
    }

    public Object get_suites(int project_id) throws Exception {
        String uri = String.format("get_suites/%d", project_id);
        return this.sendGet(uri);
    }

    public Object add_suite(int project_id, Object data) throws Exception {
        String uri = String.format("add_suite/%d", project_id);
        return this.sendPost(uri, data);
    }

    public Object update_suite(int suite_id, Object data) throws Exception {
        String uri = String.format("update_suite/%d", suite_id);
        return this.sendPost(uri, data);
    }

    public Object delete_suite(int suite_id) throws Exception {
        String uri = String.format("delete_section/%d", suite_id);
        return this.sendPost(uri, null);
    }

    // API: Template

    public Object get_templates(int project_id) throws Exception {
        String uri = String.format("get_templates/%d", project_id);
        return this.sendGet(uri);
    }

    // API: Tests

    public Object get_test(int test_id) throws Exception {
        String uri = String.format("get_test/%d", test_id);
        return this.sendGet(uri);
    }

    public Object get_tests(int run_id, String filter) throws Exception {
        String uri = String.format("get_tests/%d", run_id);
        if (filter != "") {
            uri += uri + filter;
        }
        return this.sendGet(uri);
    }

    // API: Users

    public Object get_user(int user_id) throws Exception {
        String uri = String.format("get_user/%d", user_id);
        return this.sendGet(uri);
    }

    public Object get_user_by_email(String email) throws Exception {
        String uri = String.format("get_user_by_email&email=%s", email);
        return this.sendGet(uri);
    }

    public Object get_users() throws Exception {
        String uri = "get_users";
        return this.sendGet(uri);
    }
}
