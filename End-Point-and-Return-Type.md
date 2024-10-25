# End Point and Return Type

User Admin
1. As a user admin, I want to create user accounts so that users can log in - Done
   Controller: AdminCreateUserController
   Endpoint: "/InfinityNetwork/admin/createUser"
   Request Method: fetch
   Payload to receive: JSON
   Payload example:
   Content-Type: application/json
   {
   "username": "admin",
   "email": "admin@admin.com",
   "password": "admin",
   "userType": "ADMIN",
   "phoneNumber": "12345678",
   }
   Expected return type: String
   Return object example:
   Success case: success
   Failure case: "error: (conn=1340) Duplicate entry 'admin@admin.com' for key 'UKmbarshl1giy6v93ewbfoqtim2'"

2. As a user admin, I want to be able to view user accounts so that I can update the user accounts - Done
   Controller: AdminFetchAllUserController
   Endpoint: "/InfinityNetwork/admin/fetchAllUser"
   Request Method: fetch / get
   Payload to receive: none
   Expected return type: List<UserEntity> (in JSON format)
   Return object example:
   [
   {
   "username": "admin",
   "email": "admin@admin.com",
   "enabled": true,
   "password": "admin",
   "userType": "ADMIN",
   "phoneNumber": "12345",
   "averageRating": 0.0,
   "created_At": "2024-10-17 16:46:49.000",
   "updated_At": "2024-10-17 16:47:01.000"
   },
   {
   "username": "test",
   "email": "tes",
   "enabled": true,
   "password": "admin",
   "userType": "ADMIN",
   "phoneNumber": "23213",
   "averageRating": 0.0,
   "created_At": "2024-10-17 19:13:20.000",
   "updated_At": "2024-10-17 19:13:40.000"
   },
   {
   "username": "adminAAA",
   "email": "adminAAA@admin.com",
   "enabled": true,
   "password": "admin",
   "userType": "ADMIN",
   "phoneNumber": "23418888",
   "averageRating": 0.0,
   "created_At": "2024-10-18 17:08:46.181",
   "updated_At": "2024-10-18 17:08:46.181"
   },
   {
   "username": "tester",
   "email": "tester@test.com",
   "enabled": true,
   "password": "test",
   "userType": "ADMIN",
   "phoneNumber": "11112222",
   "averageRating": 0.0,
   "created_At": "2024-10-18 17:53:51.151",
   "updated_At": "2024-10-18 17:53:51.151"
   }
   ]

3. As a user admin, I want to be able to update user accounts so that I can input the latest info - Done
   Controller: AdminCreateUserController
   Endpoint: "/InfinityNetwork/admin/updateUser?originalUsername=oldUsername"
   Request Method: fetch
   Payload to receive: JSON
   Payload example:
   Content-Type: application/json
    {
    "username": "tester123",
    "email": "tester@test.com",
    "enabled": true,
    "password": "test",
    "userType": "ADMIN",
    "phoneNumber": "66666666"
    }
   Expected return type: String
   Return object example:
   Success case: success
   Failure case: "error: (conn=1471) Duplicate entry 'admin' for key 'UKatqgqm46rh7b0lrgl80ryd5tp'"
   Note: Submit the full form, even if user only update 1 value

4. As a user admin, I want to suspend user accounts so that the database isn't filled with empty or inactive accounts - Done
   Controller: AdminSuspendUserController
   Endpoint: "/InfinityNetwork/admin/suspendUser?username=username&value=1"
   Request Method: fetch
   Payload to receive: none
   Expected return type: String
   Return object example:
   Success case: success
   Failure case: User not found. OR Invalid value provided. Use 0 to disable or 1 to enable the user. OR 
   Note: 0 means suspend and 1 is enabled

5. As a user admin, I want to search user accounts so that I can find user accounts more easily - Done
   Controller: AdminSearchUserController
   Endpoint: "/InfinityNetwork/admin/searchUser?criteria=username&value=admin"
   Request Method: GET
   Payload to receive: none
   Expected return type: List<UserEntity> (in JSON format)
   Return object example:
   [
   {
   "username": "admin",
   "email": "admin@admin.com",
   "enabled": true,
   "password": "admin",
   "userType": "ADMIN",
   "phoneNumber": "12345",
   "averageRating": 0.0,
   "created_At": "2024-10-17 16:46:49.000",
   "updated_At": "2024-10-17 16:47:01.000"
   },
   {
   "username": "adminAAA",
   "email": "adminAAA@admin.com",
   "enabled": true,
   "password": "admin",
   "userType": "ADMIN",
   "phoneNumber": "23418888",
   "averageRating": 0.0,
   "created_At": "2024-10-18 17:08:46.181",
   "updated_At": "2024-10-18 17:08:46.181"
   }
   ]
   Note: allow for partial search, can only search by 4 kind of info: username, email, userType, phoneNumber

6. As a user admin, I want to create user profiles so that users can be differentiated - Done
   Controller: AdminCreateProfileController
   Endpoint: "/InfinityNetwork/admin/createProfile?profileName=TEST"
   Request Method: fetch
   Payload to receive: none
   Expected return type: String
   Return object example:
   Success case: success
   Failure case: error: message
   
7. As a user admin, I want to be able to view user profiles so that I can find out the current types of profiles available
   Controller: AdminFetchAllProfileController
   Endpoint: "/InfinityNetwork/admin/fetchAllProfile"
   Request Method: GET
   Payload to receive: none
   Expected return type: List
   Return object example:
   [
   "ADMIN",
   "AGENT",
   "BUYER",
   "SELLER",
   "TEST"
   ]
   Success case: success
   Failure case: None

8. As a user admin, I want to be able to update user profile so that I can input the latest info
   Controller: AdminUpdateProfileController
   Endpoint: "/InfinityNetwork/admin/updateProfile?oldProfileName=TEST&newProfileName=MANAGER"
   Request Method: FETCH
   Payload to receive: none
   Expected return type: String
   Return object example:
   Success case: success
   Failure case: error: message OR other message

9. As a user admin, I want to delete user profiles so that redundant user profiles doesn't occupy the database
   Controller: AdminDeleteProfileController
   Endpoint: "/InfinityNetwork/admin/deleteProfile?profileName=MANAGER"
   Request Method: FETCH
   Payload to receive: none
   Expected return type: String
   Return object example:
   Success case: success
   Failure case: error: message OR other message
   
10. As a user admin, I want to search user profiles so that I can have an easier time finding specific profiles
    //TODO, as im not sure what's the return type and what exactly to return, just the profile name?

11. As a user admin, I want to sign in to my account so that I can access the user accounts and user profiles - Done
    Controller: UserLoginController
    Endpoint: "/login"
    Request Method: GET
    Payload to receive: JSON
    Payload example:
    {
    "username": "admin",
    "password": "admin",
    "userType": "admin"
    }
    Expected return type: Bool
    
12. As a user admin, I want to log out of my account so that I can prevent other users from accessing my account - Done
    //TODO, as logout process in unclear

Used Car Agent
1. As a used car agent, I want to change my user account info so that it is always at the latest version - Done
   Controller: AgentUpdateAccountController
   Endpoint: "/InfinityNetwork/agent/updateUser"
   This method is calling same function as adminUpdateUser. The key different is that admin can modify any user,
   but agent should only be able to modify themselves, so make sure when you call this function,
   hard-code the username to current user. Other info please refer to adminUpdateUser

2. As a used car agent, I want to be able to view car listings so that I can find out the current listings - Done
   Controller: fetchAllListingController
   Endpoint: "/InfinityNetwork/agent/fetchAllListing"
   Request Method: GET
   Payload to receive: none
   Expected return type: List<CarListing>
   Return object example:
   Success case: success
   Failure case: error: message OR other message
   
3. As a used car agent, I want to create a new car listing so that I can display a new used car to potential buyers - Done

4. As a used car agent, I want to be able to update car listings so that I can input the latest info - Done
5. As a used car agent, I want to delete car listings so that I can show that the car is de-listed to buyers - Done
6. As a used car agent, I want to search car listings so that I can have an easier time finding specific car listings -Done
7. As a used car agent, I want to view ratings about me so that I can understand what buyers and sellers think about my service - Done
   //TODO, unclear about frontend presentation, does frontend request rating and review 1 shot at the same time, or this
   will be 2 separate pages, not sure if 1 controller for both or need 2 controller

8. As a used car agent, I want to view reviews about me so that I can understand what buyers and sellers think about my service - Done
   Refer to above point

9. As a used car agent, I want to sign in to my account so that I can access the car listings - Done
   Controller: UserLoginController
   All user will use the same controller, can't split to 4 since they use same endpoint address to log in

10. As a used car agent, I want to log out of my account so that I can prevent other users from accessing my account - Done
    //TODO, as logout process is unclear

Seller
1. As a seller, I want to sign in to my account so that I can access the car listings - Done
   Controller: UserLoginController
   All user will use the same controller, can't split to 4 since they use same endpoint address to log in

2. As a seller, I want to log out of my account so that I can prevent other users from accessing my account - Done
   //TODO, as logout process is unclear

3. As a seller, I want to change my user account info so that it is always at the latest version - Done
   Controller: SellerUpdateAccountController
   Endpoint: "/InfinityNetwork/seller/updateUser"
   This method is calling same function as adminUpdateUser. The key different is that admin can modify any user,
   but seller should only be able to modify themselves, so make sure when you call this function,
   hard-code the username to current user. Other info please refer to adminUpdateUser

4. As a seller, I want to rate used car agents so that I can provide feedback to the agent and other customers for them to learn from my experience. - Done
   Controller: SellerRateAgentController
   Endpoint: "/InfinityNetwork/seller/rateAgent"
   Request Method: FETCH
   Payload to receive: JSON
   Payload example:
   {
   "comment": "", //this field accept empty comments, and in that case it will become a pure rating
   "rating": 3,
   "reviewFor": "admin",
   "reviewBy": "test"
   }
   Expected return type: String
   Success case: success
   Failure case: error: message OR other message

5. As a seller, I want to review used car agents so that the agent and other customers can learn from my experience with them. - Done
   Review and rating is the same function, you can just submit an empty comments

6. As a seller, I want to see the number of views on my used cars so that I can track the interests on the used car - Can't do since I'm not doing Buyer class
7. As a seller, I want to see the number of time my used car is shortlisted so that I can track the interests on my used car - Can't do since I'm not doing Buyer class