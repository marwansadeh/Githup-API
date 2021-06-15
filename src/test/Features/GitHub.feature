@GithubAPI
Feature: Github API

  Scenario Outline: Verify GitHub API
    Given Call GET API with <keys> key and <values> value.
    Then Verify that the response statusCode is <statusCode>.

    @RegressionTest @Positive
    Examples:
      | keys                           | values                            | statusCode |
      | description                    | java                              | 200        |
      | location                       | Remote                            | 200        |
      | lat,long                       | 37.3229978,-122.0321823           | 200        |
      | full_time                      | true                              | 200        |
      | search                         | node                              | 200        |
      | description,location           | java,Remote                       | 200        |
      | description,lat,long           | java,37.3229978,-122.0321823      | 200        |
      | description,full_time          | java,true                         | 200        |
      | description,search             | java,node                         | 200        |
      | description,location,full_time | java,Remote,true                  | 200        |
      | description,location,search    | java,Remote,node                  | 200        |
      | description,lat,long,full_time | java,37.3229978,-122.0321823,true | 200        |
      | description,lat,long,search    | java,37.3229978,-122.0321823,node | 200        |
      | description,full_time,search   | java,true,node                    | 200        |
      | description,full_time,search   | java,true,node                    | 200        |
      | description,full_time,search   | java,true,node                    | 200        |

    @RegressionTest @Negative
    Examples:
      | keys                                           | values                                        | statusCode |
      | test                                           | test                                          | 200        |
      | lat                                            | 37.3229978                                    | 200        |
      | long                                           | -122.0321823                                  | 200        |
      | location,lat                                   | Remote,37.3229978                             | 200        |
      | location,long                                  | Remote,-122.0321823                           | 200        |
      | location,lat,long                              | Remote,37.3229978,-122.0321823                | 200        |
      | description,location,lat,long,full_time,search | java,Remote,37.3229978,-122.0321823,true,node | 200        |
      | description,location,lat,long                  | java,Remote,37.3229978,-122.0321823           | 200        |
      | full_time,search,lat                           | java,true,node,37.3229978                     | 200        |
      | full_time,search,long                          | java,true,node,-122.0321823                   | 200        |
      |                                                |                                               | 200        |

    @SmokeTest
    Examples:
      | keys        | values                  | statusCode |
      | description | java                    | 200        |
      | location    | Remote                  | 200        |
      | lat,long    | 37.3229978,-122.0321823 | 200        |
      | full_time   | true                    | 200        |
      | search      | node                    | 200        |