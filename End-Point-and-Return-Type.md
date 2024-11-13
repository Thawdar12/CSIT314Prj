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

4. As a user admin, I want to suspend user accounts so that the database isn't filled with empty or inactive accounts -
   Done
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

7. As a user admin, I want to be able to view user profiles so that I can find out the current types of profiles
   available
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
   Controller: AdminSuspendProfileController
   Endpoint: "/InfinityNetwork/admin/suspendUserProfile?profileName=admin&value=1"
   Request Method: FETCH
   Payload to receive: none
   Expected return type: String
   Return object example:
   Success case: success
   Failure case: error: message OR other message
   Note: value 0 for false, 1 for true, so you can resume all user under the profile

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
   Success case: List
   Failure case: error: message OR other message

3. As a used car agent, I want to create a new car listing so that I can display a new used car to potential buyers -
   Done
   Controller: AgentCreateListingController
   Endpoint: "/InfinityNetwork/agent/createListing"
   Request Method: POST
   Payload to receive: Multipart/json
   Payload example:
   listing
   {
   "carBrand": "Toyota",
   "carModel": "Corolla",
   "carPlateNumber": "ABC12345",
   "listingStatus": "OPEN",
   "manufacturedYear": 2020,
   "millage": 15000.5,
   "price": 20000.0,
   "listedBy": "102",
   "sellerID": "103"
   }

   //Photo file, optional

   Expected return type: String
   Return object example:
   Success case: success
   Failure case: error: failure or other error message

4. As a used car agent, I want to be able to update car listings so that I can input the latest info - Done
   Controller: AgentCreateListingController
   Endpoint: "/InfinityNetwork/agent/updateListing?originalCarPlateNumber=ABC123"
   Request Method: POST
   Payload to receive: Multipart/json
   Expected return type: String
   Return object example:
   Success case: success
   Failure case: error: failure or other error message

   Note: submit entire form with every detail, even if user only update 1 info, rest is the same as create
5. As a used car agent, I want to delete car listings so that I can show that the car is de-listed to buyers - Done
   Controller: AgentDeleteListingController
   Endpoint: "/InfinityNetwork/agent/deleteListing?carPlateNumber=ABC12345678"
   Request Method: POST
   Payload to receive: None
   Expected return type: String
   Return object example:
   Success case: success
   Failure case: error: failure or other error message

6. As a used car agent, I want to search car listings so that I can have an easier time finding specific car listings
   -Done
   Controller: AgentSearchListingController
   Endpoint: "/InfinityNetwork/agent/searchListing?criteria=carPlateNumber&value=ABC123"
   Request Method: GET
   Payload to receive: None
   Expected return type: List<CarListing>
   Return object example:
   [
   {
   "carBrand": "test",
   "carModel": "Test",
   "carPlateNumber": "ABC123",
   "created_at": "2024-10-27T19:22:41",
   "listingStatus": "OPEN",
   "manufacturedYear": 2000,
   "millage": 2090.0,
   "photo": null,
   "price": 2000.0,
   "updated_at": "2024-10-27T19:23:06",
   "listedBy": "102",
   "sellerID": "103"
   }
   ]

7. As a used car agent, I want to view ratings about me so that I can understand what buyers and sellers think about my
   service - Done
   Controller: AgentFetchRatingController
   Endpoint: "/InfinityNetwork/agent/fetchRating?agentUserID=102"
   Request Method: GET
   Payload to receive: None
   Expected return type: List<ReviewEntity>
   Return object example:
   [
   {
   "comment": "GoodJob",
   "rating": 5.0,
   "reviewFor": "102",
   "reviewBy": "103",
   "createdAt": "2024-10-22T23:27:34.943"
   },
   {
   "comment": "BadJob",
   "rating": 3.0,
   "reviewFor": "102",
   "reviewBy": "103",
   "createdAt": "2024-10-22T23:27:50.341"
   }
   ]
8. As a used car agent, I want to view reviews about me so that I can understand what buyers and sellers think about my
   service - Done
   Refer to above point

9. As a used car agent, I want to sign in to my account so that I can access the car listings - Done
   Controller: UserLoginController
   All user will use the same controller, can't split to 4 since they use same endpoint address to log in

10. As a used car agent, I want to log out of my account so that I can prevent other users from accessing my account -
    Done
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

4. As a seller, I want to rate used car agents so that I can provide feedback to the agent and other customers for them
   to learn from my experience. - Done
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

5. As a seller, I want to review used car agents so that the agent and other customers can learn from my experience with
   them. - Done
   Review and rating is the same function, you can just submit an empty comments

6. As a seller, I want to see the number of views on my used cars so that I can track the interests on the used car -
   Can't do since I'm not doing Buyer class
   - Done
7. As a seller, I want to see the number of time my used car is shortlisted so that I can track the interests on my used
   car - Can't do since I'm not doing Buyer class
   - Done

Buyer
1. As a buyer, I want to be able to view car listings so that I can find out the current listings 
- Service - Done
      Controller: BuyerfetchAllListingController
      Endpoint: "/InfinityNetwork/buyer/fetchAllListingForBuyer"
      Request Method: GET
      Payload to receive: none
      Expected return type: List<CarListing>
      Return object example: [
  {
  "carBrand": "Polestar",
  "carModel": "PT Cruiser",
  "carPlateNumber": "RM12MVX",
  "created_at": "2024-11-08T01:49:09.55",
  "listingStatus": "OPEN",
  "manufacturedYear": 2006,
  "millage": 2356.11,
  "photo": "/img/car(6).jpg",
  "price": 700012.0,
  "updated_at": "2024-11-10T20:54:06.671",
  "listedBy": "Roy.Kerluke",
  "sellerUsername": "Ari_Mraz",
  "viewCount": 3348
  }
]
      Success case: List
      Failure case: error: message OR other message

2. As a buyer, I want to view used car listings (view favourite car listing) so that I can find out which used car I want to buy
   service - Done
   Controller: BuyerFetchAllFavController
   Endpoint: "/InfinityNetwork/buyer/fetchAllFavoriteListings?username=Hayden47"
   Request Method: GET
   Payload to receive: None
   Expected return type: List<CarListing>
   Return object example:
   [
   {
   "carBrand": "Ford",
   "carModel": "Jetta",
   "carPlateNumber": "JJ87MQV",
   "created_at": "2024-10-28T21:17:56.753",
   "listingStatus": "OPEN",
   "manufacturedYear": 2016,
   "millage": 12427.85,
   "photo": "/img/car(4).jpg",
   "price": 646085.0,
   "updated_at": "2024-11-11T19:24:34.723",
   "listedBy": "Dale_Graham",
   "sellerUsername": "Percy_Effertz67",
   "viewCount": 7507
   },
   {
   "carBrand": "Porsche",
   "carModel": "911",
   "carPlateNumber": "SU91KDN",
   "created_at": "2024-11-01T02:48:37.364",
   "listingStatus": "OPEN",
   "manufacturedYear": 2015,
   "millage": 25803.64,
   "photo": "/img/car(11).jpg",
   "price": 465634.0,
   "updated_at": "2024-11-12T09:31:31.651",
   "listedBy": "Candelario_Larkin",
   "sellerUsername": "Emery.Hane22",
   "viewCount": 2447
   }
   ]
   
3. As a buyer, I want to search used car listings so that I can search for cars that fit my criteria
   -Done
   Controller: BuyerSearchListingController
   Endpoint: "/InfinityNetwork/buyer/searchListing?criteria=carPlateNumber&value=ABC123"
   Request Method: GET
   Payload to receive: None
   Expected return type: List<CarListing>
   Return object example:
   [
   {
   "carBrand": "test",
   "carModel": "Test",
   "carPlateNumber": "ABC123",
   "created_at": "2024-10-27T19:22:41",
   "listingStatus": "OPEN",
   "manufacturedYear": 2000,
   "millage": 2090.0,
   "photo": null,
   "price": 2000.0,
   "updated_at": "2024-10-27T19:23:06",
   "listedBy": "102",
   "sellerID": "103"
   }
   ]
   
4. As a buyer, I want to save used car listings so that I can refer to preferred used car listings easily
Done

   
5. As a buyer, I want to remove used car listings so that I can update my current preferred car listing
Done
   
6. As a buyer, I want to access a loan calculator so that I can determine if the selected used car is within my budget
   
7. As a buyer, I want to rate and review used car agents so that I can provide feedback to the agent and other customers for them to learn from my experience.
Done
Controller: BuyerRateAgentController
      Endpoint: "/InfinityNetwork/buyer/rateAgent"
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
   
8. As a buyer, I want to sign in to my account so that I can access the car listings
Done
   
9. As a buyer, I want to log out of my account so that I can prevent other users from accessing my account
Done


10. As a buyer, I want to change my user account info so that it is always at the latest version - Done
       Controller: BuyerUpdateAccountController
       Endpoint: "/InfinityNetwork/buyer/updateUser"
       This method is calling same function as adminUpdateUser. The key different is that admin can modify any user,
       but buyer should only be able to modify themselves, so make sure when you call this function,
       hard-code the username to current user. Other info please refer to adminUpdateUser
