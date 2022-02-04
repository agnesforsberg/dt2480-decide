# DT2480-Decide

DT2480-Decide is a University assignment where the aim was to create a fake anti-ballistic system that can decide whether a missile should be sent or not depending on a variety of customizable conditions. 


The system works by evaluating 15 conditions, or LICs (launch Interceptor Conditions). Each of these conditions is managed by a LICx method. Once each condition is evaluated, they are compared using the LCM (Logical Connector Matrix) and the results of these comparisons are stored in the PUM (Preliminary Unlocking Matrix). The system then uses the PUV (Preliminary Unlocking Vector) to determine whether a condition will be used in the decision to launch the missile. The combination of the PUV and the PUM gives the Final Unlocking Vector (FUV). By evaluating if all values in the FUV are true or not the system can decide if the missile should be launched or not.  


## Statement of contributions:
#### Thomas:
- LIC 2, 7 and 12 and the associated tests and auxiliary functions needed.
- README skeleton.

#### Agnes:
- Project lead - created the repo & issues, assigned issues to the group, code checking all PRs except for my own
- Code skeleton
- LICs 4, 9, 14

#### Fredrik Svanholm:
- LIC 0, 5 and 10 and the associated tests and auxiliary functions needed.
- decide, CMV and PUM methods.

#### Nicolas Wittmann
- LIC 3, 8, 13 and the associated tests and auxiliary functions needed.

#### Malin Svenberg
- LIC 1, 6, 11 and the associated tests and auxiliary functions needed. 
- FUV and Launch methods, including the main tests for the program (DeciderTest). 

## Way of Working:
Our way of working is “In Place”. Indeed, we have selected our tools and practices. The group used a Slack channel for all main communication and used different channels to organize the discussions. For instance a general channel for discussion or a meeting channel to know when the next meeting was scheduled. The Project was managed with GitHub. Initially, each member got a set of issues to work on. The group then created branches associated with each issue and just worked on resolving each issue.  When an issue was resolved, a pull request was created and the project’s leader evaluated the code and requested changes if needed. When it came to the project leader’s code, the leader assigned someone else to review their contribution in order to have another point of view. With this method of work, everyone was able to get feedback on their code either directly on GitHub or through a Slack discussion. In order to go to the next step, we need to improve our practices a bit in order to avoid some merge conflict and use a bit more these practices and tools in order to make them more natural. 
