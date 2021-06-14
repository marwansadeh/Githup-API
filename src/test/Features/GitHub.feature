@GithubAPI
Feature: Github API

  Scenario Outline: Verify GitHub API
    Given Call GET API with <keys> key and <values> value.

    @RegressionTest
    Examples:
      | keys                                           | values                                        |
      | description                                    | java                                          |
      | location                                       | Remote                                        |
      | lat,long                                       | 37.3229978,-122.0321823                       |
      | full_time                                      | true                                          |
      | search                                         | node                                          |
      | description,location                           | java,Remote                                   |
      | description,lat,long                           | java,37.3229978,-122.0321823                  |
      | description,full_time                          | java,true                                     |
      | description,search                             | java,node                                     |
      | description,location,full_time                 | java,Remote,true                              |
      | description,location,search                    | java,Remote,node                              |
      | description,location,lat,long                  | java,Remote,37.3229978,-122.0321823           |
      | description,lat,long,full_time                 | java,37.3229978,-122.0321823,true             |
      | description,lat,long,search                    | java,37.3229978,-122.0321823,node             |
      | description,full_time,search                   | java,true,node                                |
      | description,location,lat,long,full_time,search | java,Remote,37.3229978,-122.0321823,true,node |

    @SmokeTest
    Examples:
      | keys        | values                  |
      | description | java                    |
      | location    | Remote                  |
      | lat,long    | 37.3229978,-122.0321823 |
      | full_time   | true                    |
      | search      | node                    |