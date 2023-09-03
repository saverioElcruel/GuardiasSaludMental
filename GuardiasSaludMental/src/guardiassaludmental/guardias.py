# def esValido(guardia, doc, guardias):
#     # Check if the doctor was assigned to the previous shift
#     if guardia["id"] > 0 and guardias[guardia["id"] - 1] == doc["name"]:
#         print(f"Guard {doc['name']} cannot be assigned on {guardia['fecha']} ({guardia['turno']}) due to consecutive assignment.")
#         return False

#     # Check for guard availability
#     tiene_dispo = dispDia(doc, guardia["dia"]) if guardia["turno"] == "dia" else dispNoche(doc, guardia["dia"])
#     if not tiene_dispo:
#         print(f"Guard {doc['name']} is not available on {guardia['fecha']} ({guardia['turno']}).")
#         return False
    
#     # Check for guard leave days
#     if doc["comienzoLicencia"] <= guardia["fecha"] <= doc["finLicencia"]:
#         print(f"Guard {doc['name']} is on leave on {guardia['fecha']} and cannot be assigned.")
#         return False

#     return True

# # Run the function again to see the debugging output
# result_debug = nGuardias(30)
# result_debug

import random

# Generate a list of 10 doctors with random attribute values
docs = [{
        "name": "Hector",
        "dispDia": "LMXJVSD",
        "dispNoche": "LMXJVSD",
        "trabaja24": True,
        "comienzoLicencia": "2023-07-01",
        "finLicencia": "2023-07-15"
    },{
        "name": "Maru",
        "dispDia": "LV",
        "dispNoche": "SD",
        "trabaja24": False,
        "comienzoLicencia": "2023-09-01",
        "finLicencia": "2023-09-10"
    },{
        "name": "Lau S.",
        "dispDia": "LMXJVSD",
        "dispNoche": "MS",
        "trabaja24": True,
        "comienzoLicencia": "2023-09-01",
        "finLicencia": "2023-09-10"
    },{
        "name": "Rodo",
        "dispDia": "LMXJVSD",
        "dispNoche": "LMXJVSD",
        "trabaja24": True,
        "comienzoLicencia": "2023-06-26",
        "finLicencia": "2023-07-15"
    },{
        "name": "Javier",
        "dispDia": "LMXJSD",
        "dispNoche": "LMSD",
        "trabaja24": True,
        "comienzoLicencia": "2023-06-16",
        "finLicencia": "2023-06-21"
    },{
        "name": "Flor",
        "dispDia": "LMXJSD",
        "dispNoche": "LMSD",
        "trabaja24": False,
        "comienzoLicencia": "2023-06-16",
        "finLicencia": "2023-06-22"
    },{
        "name": "Luisi",
        "dispDia": "LXJSD",
        "dispNoche": "D",
        "trabaja24": False,
        "comienzoLicencia": "2023-06-16",
        "finLicencia": "2023-07-01"
    },{
        "name": "Lucia",
        "dispDia": "LVSD",
        "dispNoche": "LMJSD",
        "trabaja24": False,
        "comienzoLicencia": "2023-09-16",
        "finLicencia": "2023-10-01"
    },{
        "name": "Lorena",
        "dispDia": "MVS",
        "dispNoche": "",
        "trabaja24": False,
        "comienzoLicencia": "2023-09-16",
        "finLicencia": "2023-10-01"
    },{
        "name": "Julia",
        "dispDia": "VSD",
        "dispNoche": "MXSD",
        "trabaja24": True,
        "comienzoLicencia": "2023-09-16",
        "finLicencia": "2023-10-01"
    },{
        "name": "Anto",
        "dispDia": "LMXJVSD",
        "dispNoche": "LMXJVSD",
        "trabaja24": False,
        "comienzoLicencia": "2023-09-16",
        "finLicencia": "2023-10-01"
    }]

from datetime import datetime, timedelta

def nGuardias(n):
    guardia_inicio = datetime.strptime("2023-08-22", "%Y-%m-%d")
    dia_semana = guardia_inicio.weekday()
    nombre_dia = ["D", "L", "M", "X", "J", "V", "S"]
    guardia = {"id": 0, "fecha": guardia_inicio, "turno": "dia", "dia": nombre_dia[dia_semana]}

    guardias = [None] * n
    
    print(guardias)
    
    return asignarGuardia(guardia, guardias, n)

# Adding a dictionary to keep track of holiday shifts assigned to each doctor
holiday_shifts = {doc["name"]: 0 for doc in docs}



def esValido(guardia, doc, guardias):
    # Check if the doctor was assigned to the previous shift, and the current shift is a day shift (not allowed after a night shift)
    if guardia["id"] > 0 and guardias[guardia["id"] - 1] == doc["name"] and guardia["turno"] == "dia":
        print(f"Doctor {doc['name']} cannot be assigned on {guardia['fecha']} ({guardia['turno']}) due to consecutive assignment.")
        return False

    # Check for doctor availability
    tiene_dispo = dispDia(doc, guardia["dia"]) if guardia["turno"] == "dia" else dispNoche(doc, guardia["dia"])
    if not tiene_dispo:
        print(f"Doctor {doc['name']} is not available on {guardia['fecha']} ({guardia['turno']}).")
        return False
    
    # Check for doctor leave days
    if doc["comienzoLicencia"] <= guardia["fecha"] <= doc["finLicencia"]:
        print(f"Doctor {doc['name']} is on leave on {guardia['fecha']} and cannot be assigned.")
        return False

    # Check for equitable holiday shifts
    if guardia["dia"] == "D" and holiday_shifts[doc["name"]] >= (30/7) / len(docs):  # Assuming 30 days, 4 Sundays, divided by number of doctors
        print(f"Doctor {doc['name']} has already been assigned the maximum number of holiday shifts.")
        return False

    return True

# Adjusting the assignment function to update the holiday shifts count
def asignarGuardia(guardia, guardias, n):
    if guardia["id"] == (n - 1):
        return guardias
    else:
        total_sol = 0
        for doc in docs:
            if esValido(guardia, doc, guardias):
                guardias[guardia["id"]] = doc["name"]
                if guardia["dia"] == "D":
                    holiday_shifts[doc["name"]] += 1
                guardia_siguiente = siguienteGuardia(guardia)
                total_sol += asignarGuardia(guardia_siguiente, guardias, n)
        return total_sol

def dispDia(doc, dia):
    return dia in doc["dispDia"]

def dispNoche(doc, dia):
    return dia in doc["dispNoche"]

def siguienteGuardia(guardia):
    siguiente_fecha = guardia["fecha"]

    if guardia["turno"] == "noche":
        siguiente_fecha += timedelta(days=1)

    siguiente_turno = "noche" if guardia["turno"] == "dia" else "dia"
    siguiente_id = guardia["id"] + 1

    return {"id": siguiente_id, "fecha": siguiente_fecha, "turno": siguiente_turno}

# Run the function again with the new logic
result_debug = nGuardias(30)
result_debug

# Run the function with the new set of doctors
result_debug = asignarGuardia({"id": 0, "fecha": "2023-08-01", "dia": "D", "turno": "dia"}, [""] * 30, 30)
print(result_debug)