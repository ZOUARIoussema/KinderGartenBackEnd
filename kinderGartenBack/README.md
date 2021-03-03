# GET Token

	Post
	
	http://localhost:8081/kinderGarten/servlet/user/authenticate
	
	{
    "email":"_____",
    "password":"_____"
    }
    
    
# add user

    Post

    http://localhost:8081/kinderGarten/servlet/user/add
    
    {
    "firstName":"zouari",
    "lastName":"oussema",
    "adress":"ariana",
    "email":"oussema.zouari@esprit.com",
    "password":"testuser",
    "role":"ROLE_parent",
    "tel":212121
    }
    
# get All user

    Get
    
    http://localhost:8081/kinderGarten/servlet/useradmin/findAll
    
    Authorization : Bearer Token
    
    
    
    


# update user

Put

http://localhost:8081/kinderGarten/servlet/user/update

 {
     "id":10,
    "firstName":"zouari",
    "lastName":"oussema",
    "adress":"ariana",
    "email":"oussema.zouari@esprit.com",
    "password":"testuser",
    "role":"ROLE_parent",
    "tel":242424
 }
 
 
 


# send secret key
Post

http://localhost:8081/kinderGarten/servlet/user/sendSecretKey/oussema.zouari@esprit.tn


# change pwd 
Put
http://localhost:8081/kinderGarten/servlet/user/changepwd/10/testt/7433


# add medical visit 
Post
http://localhost:8081/kinderGarten/servlet/medical/addMedicalVisit

{
    "dateStart":"2019-02-03 10:08:02",
    "dateEnd":"2019-02-03 10:08:02",
    "doctor":{
        "id":"5"
    }
        
    
}
# update medical visit
Put

http://localhost:8081/kinderGarten/servlet/medical/updateMedicalVisit

{
    "id":"1",
    "dateStart":"2019-02-04 10:08:02",
    "dateEnd":"2019-02-04 10:08:02",
    "doctor":{
        "id":"5"
    }
        
    
}
# get All medical visit
Get
http://localhost:8081/kinderGarten/servlet/medical/getAllMedicalVisit

# delete medical visit
Delete
http://localhost:8081/kinderGarten/servlet/medical/deleteVisitMedical/1

# add folder medical
Post

http://localhost:8081/kinderGarten/servlet/medical/addFolderMedical

{

     "dateC":"2021-03-01",
     "allergy":"allergy",
     "child":{
         "id":"1"
     }

}
# delete folder medical
Delete
http://localhost:8081/kinderGarten/servlet/medical/deleteFolderMedical/1

# get folder medical By child
Get
http://localhost:8081/kinderGarten/servlet/medical/getFoldderMedicalByChild/1
# add medical consultation
Post

http://localhost:8081/kinderGarten/servlet/medical/addMedicalConsultation

{
    "description":"des1",
    "weight":"30",
    "height":"75",
    "doctor":{
        "id":"5"

    },
    "folderMedical":{
        "id":"2"
    }
}
# update medical consultation
Put
http://localhost:8081/kinderGarten/servlet/medical/updateConsultationMedical

{
    "id":"1",
    "dateC":"2021-03-02",
    "description":"des12222",
    "weight":"30",
    "height":"75",
    "doctor":{
        "id":"5"

    },
    "folderMedical":{
        "id":"2"
    }
}
# get all consultation by folder medical
Get
http://localhost:8081/kinderGarten/servlet/medical/getAllConsultationByFolderMedical/2




# delete medical consultation
Delete
http://localhost:8081/kinderGarten/servlet/medical/deleteConsultation/2
# add spent
Post
http://localhost:8081/kinderGarten/servlet/accounting/addSpent
{
    "description":"des1",
    "type":"purchase",
    "total":"50",
    "agentCashier":{
        "id":"3"
    }
}

# delete spent
Delete
http://localhost:8081/kinderGarten/servlet/accounting/deleteSpent/1


# update spent
Put
http://localhost:8081/kinderGarten/servlet/accounting/updateSpent
{
    "id":"2",
    "dateC":"2021-03-02",
    "description":"de2020",
    "type":"purchase",
    "total":"50",
    "agentCashier":{
        "id":"3"
    }
}
# get all by agent 
Get
http://localhost:8081/kinderGarten/servlet/accounting/getAllSpentByAgent/3

# add payement hand to hand
Post
http://localhost:8081/kinderGarten/servlet/accounting/addPayementHandToHand
# update payement hand to hand
Put
http://localhost:8081/kinderGarten/servlet/accounting/updatePayementHandToHand
{
    "id":"1",
    "price":150,
    "typePayement":"cash",
    "user":{
        "id":3
    },
    "subscriptionChild":{
        "id":1
    }
}
# get all payement hand to hand by user
Get 
http://localhost:8081/kinderGarten/servlet/accounting/getAllPayementByUser/3
# get all payement hand to hand by subscription child
Get
http://localhost:8081/kinderGarten/servlet/accounting/getAllPayementBySubscription/1
