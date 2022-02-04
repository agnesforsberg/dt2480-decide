# dt2480-decide

The goal of this project is to create an anti-ballistic system that can decide whether a missile should be sent or not depending on the different conditions imposed. 
For that, we work with 15 conditions or LIC (launch Interceptor Condition). Each of these conditions is managed by a LICx function. Once each condition is studied, they are compared using the LCM (Logical Connector Matrix) and the results of these comparisons are stored in the PUM (Preliminary Unlocking Matrix). The system then uses the PUV (Preliminary Unlocking Vector) to determine whether or not a condition will be used in the decision to launch the missile. The combination of PUV and PUM gives the Final Unlocking Vector (FUV). We can then know if the missile should be launched or not.  


## Statement of contributions:
#### Thomas:
I worked on LIC 2, 7 and 12 and the associated tests and auxiliary functions needed. I then worked on the README skeleton.

#### Agnes:
I was the project lead for this lab which meant I created the repo and issues, and then together with the group assigned the issues for an equal workload. In this role I also code checked all pull requests except for my own. I created the code skeleton, and implemeted LICs 4, 9, 14.


## Way of Working:
Our way of working is “In Place”. Indeed, we have selected our tools and practices. We then use a Slack channel to talk about everything and use different channel for instance a general channel for discussion or a meeting channel to know when is the next meeting. We also use GitHub and to use it, everyone gets some issues to work on. We then create branches and just work on it.  Then, we do some pull request and the project’s leader checks if everything is fine. The project’s leader can also ask to someone else to review his contribution in order to have another point of view. We this method, everyone can have feedback on his code either directly on GitHub or on a slack discussion. In order to go to the next step, we need to improve a bit our practices in order to avoid some merge conflict and use a bit more these practices and tools in order to make them more natural. 
