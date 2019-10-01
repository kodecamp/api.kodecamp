*-------------------- Get Request -------------------- 
curl --request GET http://localhost:8080/api.kodecamp/student

-------------------** Post Request -------------------- 
curl \
  --header "Content-type: application/json" \
  --request POST \
  --data '{"id": "1", "name": "Sunil", "address": "Lucknow"}' \
  http://localhost:8080/api.kodecamp/student

-------------------- Delete Request --------------------  
curl \
  --header "Content-type: application/json" \
  --request DELETE \
  --data '{"id": 1 }' \
  http://localhost:8080/api.kodecamp/student
