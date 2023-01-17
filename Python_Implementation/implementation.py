from flask import Flask, jsonify, request
from typing import Tuple

app = Flask(__name__)

# Database of patients and appointments
patients = {
    1: {'name': 'John Smith', 'contact': '555-555-5555', 'history': 'None'},
    2: {'name': 'Jane Doe', 'contact': '555-555-5556', 'history': 'Asthma'},
}

appointments = {
    1: {'patient_id': 1, 'date': '2023-02-01', 'time': '10:00', 'reason': 'Checkup'},
    2: {'patient_id': 2, 'date': '2023-02-02', 'time': '09:00', 'reason': 'Follow-up'},
}

@app.route('/patients', methods=['GET'])
def get_patients():
    """Retrieve a list of patients based on query parameters"""
    name = request.args.get('name')
    page = request.args.get('page')
    limit = request.args.get('limit')
    sort = request.args.get('sort')
    if name:
        filtered_patients = [patient for patient in patients.values() if name.lower() in patient['name'].lower()]
    else:
        filtered_patients = list(patients.values())
    if sort:
        filtered_patients = sorted(filtered_patients, key=lambda x: x[sort])
    if page and limit:
        start = (int(page) - 1) * int(limit)
        end = start + int(limit)
        filtered_patients = filtered_patients[start:end]
    return jsonify(filtered_patients)

@app.route('/appointments', methods=['GET'])
def get_appointments():
    """Retrieve a list of appointments based on query parameters"""
    patient_id = request.args.get('patient_id')
    date = request.args.get('date')
    sort = request.args.get('sort')
    page = request.args.get('page')
    limit = request.args.get('limit')
    filtered_appointments = list(appointments.values())
    if patient_id:
        filtered_appointments = [appointment for appointment in filtered_appointments if appointment['patient_id'] == int(patient_id)]
    if date:
        filtered_appointments = [appointment for appointment in filtered_appointments if appointment['date'] == date]
    if sort:
        filtered_appointments = sorted(filtered_appointments, key=lambda x: x[sort])
    if page and limit:
        start = (int(page) - 1) * int(limit)
        end = start + int(limit)
        filtered_appointments = filtered_appointments[start:end]
    return jsonify(filtered_appointments)

@app.route('/appointments/int:appointment_id', methods=['PUT', 'DELETE'])
def update_or_cancel_appointment(appointment_id:int)->Tuple[str, int]:
#"""Reschedule or cancel an appointment"""
    if request.method == 'PUT':
        data = request.get_json()
    if not all(key in data for key in ('date', 'time', 'reason')):
        return 'Invalid appointment data', 400
        appointments[appointment_id].update(data)
        return 'Appointment rescheduled', 200
    elif request.method == 'DELETE':
        appointments.pop(appointment_id, None)
        return 'Appointment canceled', 200

@app.route('/appointments', methods=['POST'])
def create_appointment():
#"""Create a new appointment"""
    appointment_data = request.get_json()
    if not all(key in appointment_data for key in ('patient_id', 'date', 'time', 'reason')):
        return 'Invalid appointment data', 400
        next_id = max(appointments.keys()) + 1
        appointments[next_id] = appointment_data
        return 'Appointment created with ID {}'.format(next_id), 201

@app.route('/appointments/reminder', methods=['POST'])
def send_reminders():
#"""Send automated reminders to patients about upcoming appointments"""
    data = request.get_json()
    if not all(key in data for key in ('patient_id', 'appointment_id')):
        return 'Invalid data', 400
        patient = patients.get(data['patient_id'])
        appointment = appointments.get(data['appointment_id'])
    if not patient or not appointment:
        return 'Patient or appointment not found', 404
# Send reminder to patient using their contact information
# (Implementation of sending reminder could vary, depends on the system you are using)
    return 'Reminder sent to {} for appointment on {} at {}'.format(patient['name'], appointment['date'], appointment['time']), 200

@app.route('/appointments/notification', methods=['POST'])
def send_notifications():
#"""Send notifications to relevant parties when an appointment is created, updated, or canceled"""
    data = request.get_json()
    if not all(key in data for key in ('patient_id', 'appointment_id', 'action')):
        return 'Invalid data', 400
        patient = patients.get(data['patient_id'])
        appointment = appointments.get(data['appointment_id'])
    if not patient or not appointment:
        return 'Patient or appointment not found', 404
    if data['action'] == 'created':
# Send notification to relevant parties (e.g. doctor, clinic)
# (Implementation of sending notification could vary, depends on the system you are using)
        message = 'New appointment created for patient {patient}'

