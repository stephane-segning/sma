import {useStudent} from "../hooks/api-context/hook.ts";
import {CreateStudent, UpdateStudent} from "@rtb";
import {useFormik} from "formik";
import {useNavigate} from "react-router-dom";
import * as yup from "yup";

const schema = yup.object().shape({
    name: yup.string().required(),
});

interface EditStudentProps {
    id?: string; // If we have an ID, then we have the student. If not, we're a creating.
}

type ActionPayload = CreateStudent | UpdateStudent;

export function EditStudent({id}: EditStudentProps) {
    const api = useStudent();
    const navigate = useNavigate();

    const formik = useFormik<ActionPayload>({
        initialValues: {
            name: '',
        },
        validationSchema: schema,
        onSubmit: async (values) => {
            const result = await (id ? api.updateStudent(id, values) : api.createStudent(values));
            navigate(`/students/${result.data.id}`);
        }
    });

    return (
        <form onSubmit={formik.handleSubmit}>

            <label className="input input-bordered flex items-center gap-2">
                Name
                <input type="text" className="grow" name="name" value={formik.values.name}
                       onChange={formik.handleChange}/>
            </label>

            <p className='text-error'>{formik.errors.name}</p>
            <hr className='my-2'/>
            <button className='btn btn-primary' type="submit">Save</button>
        </form>
    )
}