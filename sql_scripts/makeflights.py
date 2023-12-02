import random
from datetime import timedelta, datetime

cities = ["Calgary","Edmonton","Ottawa","St. Johns",
          "Toronto","Montreal","Vancouver","Victoria",
          "Halifax","Saskatoon","Winnipeg","Regina"]

number_of_flights = 100
flight_numbers = random.sample(range(1111,2000), 100)
start_date = datetime.now()
sql_string = ""

for i in range(number_of_flights):
    flight_num = "EN" + str(flight_numbers[i])
    origin, destination = random.sample(cities,2)
    departure_datetime = start_date +  timedelta(days=random.randint(0, 45))
    arrival_datetime = departure_datetime + timedelta(hours=random.randint(0,5), minutes=random.randint(0,59))
    aircraft_id = random.randint(1,4)
    coach_price = random.randint(100,250)
    business_price = round(coach_price * 2.2)
    sql_string += ("('" + flight_num + "','" + origin + "','" + destination
                   + "','" + str(departure_datetime) + "','" + str(arrival_datetime)
                   + "'," + str(aircraft_id) + "," + str(coach_price) + "," +
                   str(business_price) + "),\n")

with open("makeflights.txt", "wt") as f:
    f.write(sql_string)

