import * as React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import axios from "axios";
import Button from '@mui/material/Button';

export default class DisciplineList extends React.Component {

    state = {
        disciplines: [],
        selection: []
    }

    columns = [
        { field: 'id', headerName: 'ID', width: 70 },
        { field: 'name', headerName: 'Name', width: 130 }
    ]

    componentDidMount() {
        axios.get('http://localhost:8080/disciplines')
            .then(res => {
                const disciplines = res.data;
                this.setState({ disciplines });
            })

    }

    deleteOnClick() {
        let newDisciplines = JSON.parse(JSON.stringify(this.state.disciplines));
        this.state.selection.map((disciplineId) => {
            axios.delete(`http://localhost:8080/disciplines/${disciplineId}`);
            newDisciplines = newDisciplines.filter((discipline) => {
                return discipline.id !== disciplineId;
            });
        });
        this.setState({disciplines: newDisciplines});
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