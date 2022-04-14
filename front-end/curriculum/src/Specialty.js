import * as React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import axios from "axios";
import Button from '@mui/material/Button';

export default class SpecialtyList extends React.Component {

    state = {
        specialties: [],
        selection: []
    }

    columns = [
        { field: 'id', headerName: 'ID', width: 70 },
        { field: 'name', headerName: 'Name', width: 130 },
        { field: 'faculty', headerName: 'Faculty', width: 130}
    ]

    componentDidMount() {
        axios.get('http://localhost:8080/specialties')
            .then(res => {
                const specialties = res.data;
                console.log(specialties)
                specialties.forEach((specialty) => {
                    console.log(specialty)
                    specialty.faculty = specialty.faculty.name;
                })

                console.log(specialties);
                this.setState({ specialties });
            })

    }

    deleteOnClick() {
        let newSpecialties = JSON.parse(JSON.stringify(this.state.specialties));
        this.state.selection.map((specialtyId) => {
            axios.delete(`http://localhost:8080/specialties/${specialtyId}`);
            newSpecialties = newSpecialties.filter((specialty) => {
                return specialty.id !== specialtyId;
            });
        });
        this.setState({specialties: newSpecialties});
    }

    addSelected(selection){
        this.setState({selection: selection})
    }

    render() {
        return (
            <div style={{ height: 400, width: '100%' }}>
                <DataGrid
                    rows={this.state.specialties}
                    columns={this.columns}
                    pageSize={5}
                    rowsPerPageOptions={[5]}
                    checkboxSelection
                    onSelectionModelChange={(selectionModel) => this.addSelected(selectionModel)}
                />
                <Button onClick={() => this.deleteOnClick()}>Delete Selected</Button>
            </div>
        )
    }
}